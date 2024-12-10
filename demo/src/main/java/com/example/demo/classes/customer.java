package com.example.demo.classes;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class customer extends account{
    private LocalDate dateOfCreation;

    public customer() {

    }

    public customer(String username, String password) {
        super(username, password);
    }

    public customer(String username, String password, LocalDate dateOfCreation) {
        super(username, password);
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDate getdateOfCreation() {
        return dateOfCreation;
    }

    public void setdateOfCreation(LocalDate dayOfCreation) {
        this.dateOfCreation = dayOfCreation;
    }

    @Override
    public String toString() {
        return "customer{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                "dateOfCreation=" + dateOfCreation +
                '}';
    }
}
