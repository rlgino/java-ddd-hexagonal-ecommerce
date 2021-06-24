package com.example.vorepository.application.controller.dto;

import com.example.vorepository.domain.Product;
import lombok.Getter;

@Getter
public class AddProductRequest {
    private Product product;
}
