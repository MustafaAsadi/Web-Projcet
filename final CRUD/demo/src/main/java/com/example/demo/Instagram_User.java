package com.example.demo;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@Entity
@Table
public class Instagram_User {
    @Id
    @SequenceGenerator(
            name  ="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "userId")
    private Long userId;
    private String username;
    private String email;
    private String password;
    private LocalDate doc;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDoc() {
        return doc;
    }

    public void setDoc(LocalDate doc) {
        this.doc = doc;
    }

    @Override
    public String toString() {
        return "Instagram_User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", doc=" + doc +
                '}';
    }
}
