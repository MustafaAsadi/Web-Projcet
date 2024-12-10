package com.example.demo.classes;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class id {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public id(long id) {
        this.id = id;
    }
    public id() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "id{" +
                "id=" + id +
                '}';
    }
}
