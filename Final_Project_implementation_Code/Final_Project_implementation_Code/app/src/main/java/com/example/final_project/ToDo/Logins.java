package com.example.final_project.ToDo;

import android.widget.BaseAdapter;

public class Logins {

    private String firstName;
    private String lastName;
    private String password;
    private String passConfirmation;

    public Logins(String firstName, String lastName, String password, String passConfirmation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.passConfirmation = passConfirmation;
    }

    public Logins() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassConfirmation() {
        return passConfirmation;
    }

    public void setPassConfirmation(String passConfirmation) {
        this.passConfirmation = passConfirmation;
    }

    @Override
    public String toString() {
        return "Logins{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", passConfirmation='" + passConfirmation + '\'' +
                '}';
    }
}
