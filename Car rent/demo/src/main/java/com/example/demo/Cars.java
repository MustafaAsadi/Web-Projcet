package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table
public class Cars extends AbstractUserID{

    private String UserName;
    private String Password;
    private String CarName;
    private Double Price;

    public Cars() {
        super(null);
    }
    public Cars(String userName, String password,Long id ,String car, Double price) {
        super(id);
        UserName = userName;
        Password = password;
        this.CarName = car;
        Price = price;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public String getCar() {
        return this.CarName;
    }

    public void setCar(String car) {
        this.CarName = car;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        this.Price = price;
    }

    @Override
    public Long defineKeyId() {
        return null;
    }

    @Override
    public String toString() {
        String id = String.valueOf(printTheId());
        return "Cars{ id = '" + id + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", CarName='" + CarName + '\'' +
                ", Price=" + Price +
                '}';
    }
}
