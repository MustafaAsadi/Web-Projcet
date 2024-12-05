package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
public abstract class AbstractUserID {
    @Id
    private Long id;

    public AbstractUserID(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public abstract Long defineKeyId();

    public Long printTheId(){
       // System.out.println(this.id + "is your id");
        return this.id;
    }

    @Override
    public String toString() {
        return "AbstractUserID{" +
                "id=" + id +
                '}';
    }
}
