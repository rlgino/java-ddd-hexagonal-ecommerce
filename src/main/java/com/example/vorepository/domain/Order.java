package com.example.vorepository.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Order {
    private UUID id;
    private OrderStatus status;
    private List<OrderItem> orderItems;
    private BigDecimal price;

    public Order(UUID id, Product prod) {
        this.id = id;
        this.orderItems = Arrays.asList(new OrderItem(prod));
        this.status = OrderStatus.CREATED;
        this.price = prod.getPrice();
    }

    public void complete() {
        validateState();
        this.status = OrderStatus.COMPLETED;
    }

    public void addOrder(Product prod) {
        validateState();
        validateProduct(prod);
        orderItems.add(new OrderItem(prod));
        price = price.add(prod.getPrice());
    }

    public void removeOrder(UUID id) {
        validateState();
        final Optional<OrderItem> item = getOrderItem(id);
        if (item.isPresent()) {
            final OrderItem orderItem = item.get();
            orderItems.remove(orderItem);
            price = price.subtract(orderItem.getPrice());
        }
    }

    private Optional<OrderItem> getOrderItem(UUID id) {
        return this.orderItems.stream().filter(orderItem -> orderItem.getId().equals(id)).findFirst();
    }

    private void validateProduct(Product prod) {
        // Validate prod
    }

    private void validateState() {
        // Validate data
    }

}
