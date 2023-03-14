package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    String id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer=" + customer.id +
                '}';
    }
}
