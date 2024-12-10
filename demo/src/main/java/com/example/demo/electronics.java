package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class electronics extends id{
    private String name;
    private Float price;
    private String manufacturer;
    private LocalDate warrantyPeriodEnd;
//   @ManyToOne
//   private store store;

    public electronics() {

    }

    public electronics(String name, Float price, LocalDate dateOfBuy, String manufacturer, LocalDate warrantyPeriodEnd) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.warrantyPeriodEnd = warrantyPeriodEnd;
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

    public void setWarrantyPeriodEnd(LocalDate warrantyPeriodEnd) {
        this.warrantyPeriodEnd = warrantyPeriodEnd;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getWarrantyPeriodEnd() {
        return warrantyPeriodEnd;
    }

    public void setWarrantyPeriodEnd(Long years) {
        this.warrantyPeriodEnd = LocalDate.now();
        this.warrantyPeriodEnd.plusYears(years);
    }

    @Override
    public String toString() {
        return "electronics{" +
                "manufacturer='" + manufacturer + '\'' +
                ", warrantyPeriodEnd=" + warrantyPeriodEnd +
                '}';
    }
}
