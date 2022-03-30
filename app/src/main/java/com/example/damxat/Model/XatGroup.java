package com.example.damxat.Model;

import java.util.ArrayList;

public class XatGroup {

    // Variables amb el nom, els usuaris i els xats del grup
    String name;
    ArrayList<String> users;
    ArrayList<Xat> xats;

    // Constructor
    public XatGroup(String name) {
        this.name = name;

    }

    public XatGroup() {
    }

    // Getters i setters
    public String getName() {
        return name;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public ArrayList<Xat> getXats() {
        return xats;
    }
}
