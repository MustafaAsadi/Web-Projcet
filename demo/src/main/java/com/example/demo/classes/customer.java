package com.example.demo.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.time.LocalDate;

@Entity
public class customer extends account{

    private LocalDate dateOfCreation;
    public customer() {

    }
    public customer(String email, String password) {
        super(email, password);

    }

    public customer(String username, String password,String email) {
        super(username, password,email);
    }

    public LocalDate getdateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation() {
        this.dateOfCreation = LocalDate.now();
    }

    @Override
    public String toString() {
        return "customer{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                "dateOfCreation=" + dateOfCreation +
                '}';
    }
}
