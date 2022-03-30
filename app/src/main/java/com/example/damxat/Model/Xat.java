package com.example.damxat.Model;

public class Xat {

    // Variables per guardar els ids del sender, receiver i el missatge
    String sender;
    String receiver;
    String message;

    // Constructors
    public Xat(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }


    public Xat() {

    }


    public Xat(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    // Getters i setters
    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }
}
