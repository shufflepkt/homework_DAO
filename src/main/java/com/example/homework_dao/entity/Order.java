package com.example.homework_dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders_1")
public class Order {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Customer customer;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "amount")
    private int amount;

    public Order(Date date, Customer customer, String productName, int amount) {
        this.date = date;
        this.customer = customer;
        this.productName = productName;
        this.amount = amount;
    }
}
