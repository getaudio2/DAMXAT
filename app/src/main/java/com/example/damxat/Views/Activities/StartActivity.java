package com.example.damxat.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.damxat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();
        //Conexió al firebase. GetCurrentUser() retorna un objecte tipus FirebaseUser amb info del user
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser!=null){
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button startLogin = findViewById(R.id.startLogin);
        Button startRegister = findViewById(R.id.startRegister);

        //Click listener del botó de login
        startLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Funció onClick per anar al loginActivity quan es fa click al botó de login
                Intent intentLogin = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intentLogin);
            }
        });

        //Cick listener del botó register
        startRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Funció onClick per anar al registerActivity quan es fa click al botó register
                Intent intentRegister = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
            }
        });
    }
}