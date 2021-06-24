package com.example.vorepository.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class OrderItem {
    private UUID id;
    private BigDecimal price;

    public OrderItem(Product prod) {
       this.id = prod.getId();
       this.price = prod.getPrice();
    }
}
