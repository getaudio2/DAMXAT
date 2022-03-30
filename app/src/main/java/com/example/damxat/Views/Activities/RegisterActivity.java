package com.example.damxat.Views.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.damxat.Model.User;
import com.example.damxat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = findViewById(R.id.registerButton);
        EditText registerUsername = findViewById(R.id.registerUsername);
        EditText registerEmail = findViewById(R.id.registerEmail);
        EditText registerPassword = findViewById(R.id.registerPassword);

        //Agafa la instancia del Firebase Authentication SDK
        auth = FirebaseAuth.getInstance();

        //Click listener del botó de registre
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = registerUsername.getText().toString();
                String email = registerEmail.getText().toString();
                String password = registerPassword.getText().toString();

                //Si els camps de text estan buits notifica l'error. En cas contrari, crida al mètode registerUser
                if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "All fields are required.", Toast.LENGTH_SHORT).show();
                }else{
                    registerUser(username, email, password);
                }

            }
        });
    }

    //Mètode per registrar a l'usuari al firebase amb les dades obtingudes dels camps de text
    public void registerUser(String username, String email, String password){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       //Si s'ha pogut registrar l'usuari, agafa la seva id
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            String userId = firebaseUser.getUid();

                            //Agafa la referencia per identificar a l'usuari
                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userId);

                            User user = new User(userId, username, "offline");

                            //Listener que comprova quan s'envia el valor de l'user a la referencia en firebase
                            reference.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    //Si s'ha enviat correctament, pasa al loginActivity
                                    if(task.isSuccessful()) {
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });

                        }else{
                            Toast.makeText(RegisterActivity.this, "You can't register with this email", Toast.LENGTH_SHORT).show();
                        }
                   }
               });
    }
}