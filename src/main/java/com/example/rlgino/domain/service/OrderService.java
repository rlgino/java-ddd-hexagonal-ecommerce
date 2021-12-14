package com.example.rlgino.domain.service;

import com.example.rlgino.domain.Product;

import java.util.UUID;

public interface OrderService {
    void createOrder(UUID uuid,Product product);
    void addProduct(UUID id, Product product);
    void completeOrder(UUID id);
    void deleteProduct(UUID id, UUID productId);
}
