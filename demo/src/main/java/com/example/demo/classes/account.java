package com.example.demo.classes;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class account extends com.example.demo.classes.id {
    private String username;
    private String password;

    @Column(unique = true)
    private String email;

    public account() {

    }


    public account( String email, String password ) {
        this.email = email;
        this.password = password;
    }

    public account( String username, String password , String email) {
        this.username = username;
        this.password = password;
        this.email    = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
