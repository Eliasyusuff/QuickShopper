package com.helpmate.helpmate.payload;

import com.helpmate.helpmate.entity.enums.Status;

public class OrderDto {
    private Long id;
    private Double price;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
