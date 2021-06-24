package com.example.vorepository.domain.service;

import com.example.vorepository.domain.Order;
import com.example.vorepository.domain.repository.OrderRepository;
import com.example.vorepository.domain.Product;

import java.util.Optional;
import java.util.UUID;

public class DomainOrderService implements OrderService {
    private final OrderRepository orderRepository;

    public DomainOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(UUID uuid, Product product) {
        final Order order = new Order(uuid, product);
        orderRepository.save(order);
    }

    @Override
    public void addProduct(UUID id, Product product) {
        final Order order = getOrder(id);
        order.addOrder(product);
        orderRepository.save(order);
    }

    @Override
    public void completeOrder(UUID id) {

    }

    @Override
    public void deleteProduct(UUID id, UUID productId) {

    }


    private Order getOrder(UUID id) {
        return orderRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
