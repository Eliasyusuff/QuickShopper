package com.helpmate.helpmate.entity;

import com.helpmate.helpmate.entity.enums.Status;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Product> productList;

    private Double price;

    private Status status;
}
