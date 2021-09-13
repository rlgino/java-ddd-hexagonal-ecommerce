package com.example.vorepository.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class OrderItem {
    private UUID id;
    private BigDecimal price;

    public OrderItem(Product prod) {
        this.id = prod.getId();
        this.price = prod.getPrice();
    }
}
