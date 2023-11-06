package com.example.appmultitarea.compra;

import java.io.Serializable;
public class Datos implements Serializable {
    private String name;
    private String lastName;
    private String address;

    public Datos(String name, String lastName, String address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public String direccion() {
        return address;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }
}