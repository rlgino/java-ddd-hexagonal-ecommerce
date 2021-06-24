package com.example.vorepository.application.controller.dto;

import com.example.vorepository.domain.Product;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateOrderRequest {
    private UUID id;
    private Product product;
}
