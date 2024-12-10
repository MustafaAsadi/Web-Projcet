package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class grocery extends id {
    private String name;
    private Float price;
    private Date expirationDate;
    private String Type;
//    @ManyToOne
//    private store store;

    public grocery () {

    }

    public grocery(String name, Float price, Date expirationDate, String type) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
