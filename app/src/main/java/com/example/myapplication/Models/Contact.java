package com.example.myapplication.Models;

public class Contact {
    private String first_name;
    private String last_name;
    private String number;

    public Contact(String first_name, String last_name, String number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
