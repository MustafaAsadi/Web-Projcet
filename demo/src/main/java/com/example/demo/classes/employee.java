package com.example.demo.classes;

import jakarta.persistence.Entity;

@Entity
public class employee extends account {
    private Float salary;
    private String position;

    public employee () {

    }
    public employee(String email, String password) {
        super(email,password);
    }
    public employee(String username, String password,String email) {
        super(username, password,email);
    }

    public employee(String username, String password,String email, Float salary, String position) {
        super(username, password,email);
        this.salary = salary;
        this.position = position;
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
                ", email='" + getEmail() + '\'' +
                ", Position='" + position + '\'' +
                '}';
    }
}
