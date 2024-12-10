package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class clothing extends id{
    private String name;
    private Float price;
    private String brand;
    private String material;
//    @ManyToOne
////    private store store;

    public clothing() {

    }

    public clothing(String name, Float price, String brand, String material) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.material = material;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "clothing{" +
                "brand='" + brand + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
