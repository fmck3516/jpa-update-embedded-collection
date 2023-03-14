package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer {
    @Id
    String id;

    @OneToMany(mappedBy = "customer")
    List<Order> orders;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", orders=" + orders +
                '}';
    }
}