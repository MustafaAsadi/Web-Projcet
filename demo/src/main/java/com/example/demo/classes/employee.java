package com.example.demo.classes;

import jakarta.persistence.Entity;

@Entity
public class employee extends account {
    private Float salary;
    private String position;

    public employee () {}

    public employee(String username, String password) {
        super(username, password);
    }

    public employee(String username, String password, Float salary, String position) {
        super(username, password);
        this.salary = salary;
        position = position;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void raiseSalary(Float raise) {
        this.salary = this.salary + raise;
    }

    @Override
    public String toString() {
        return "employee{" +
                "salary=" + salary +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", Position='" + position + '\'' +
                '}';
    }
}
