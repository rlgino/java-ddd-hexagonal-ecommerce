package com.example.rlgino.application.controller.dto;

import com.example.rlgino.domain.Product;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateOrderRequest {
    private UUID id;
    private Product product;
}
