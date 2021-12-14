package com.example.rlgino.domain.service;

import com.example.rlgino.domain.Order;
import com.example.rlgino.domain.repository.OrderRepository;
import com.example.rlgino.domain.Product;

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
        final Order order = getOrder(id);
        order.complete();
        orderRepository.save(order);
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
