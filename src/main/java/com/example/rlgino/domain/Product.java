package com.example.rlgino.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Product {
    private final UUID id;
    private BigDecimal price;
    private String productName;
}
