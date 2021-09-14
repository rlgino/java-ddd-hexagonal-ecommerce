package com.example.rlgino.domain.repository;

import com.example.rlgino.domain.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Optional<Order> findById(UUID id);
    void save(Order order);
}
