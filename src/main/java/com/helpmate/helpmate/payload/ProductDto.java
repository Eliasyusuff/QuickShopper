package com.helpmate.helpmate.payload;

import com.helpmate.helpmate.entity.Order;

public class ProductDto {
    // for creation (optional)
    //for update we need id
    private Integer id;
    private String name;
    private double price;


    public ProductDto(Order product) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
