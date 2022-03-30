package com.example.damxat.Model;

public class User {

    // Variables amb l'id, el nom i l'estat de l'usuari
    String id;
    String username;
    String status;

    // Constructor
    public User(String id, String username, String status) {
        this.id = id;
        this.username = username;
    }

    public User() {
    }

    // Getters i setters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
