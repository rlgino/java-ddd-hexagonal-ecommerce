package com.example.rlgino.infraestructure.postgres.dao;

import com.example.rlgino.domain.Order;
import com.example.rlgino.domain.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity(name = "ORDERS")
public class OrderDAO {
    @Id
    private String ID;
    private OrderStatus status;
    private BigDecimal price;
    @OneToMany(mappedBy="orderID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItemDAO> orderItems;

    public OrderDAO(Order order) {
        ID = order.getId().toString();
        status = order.getStatus();
        price = order.getPrice();
        orderItems = new ArrayList<>();
        order.getOrderItems().stream().map(item -> new OrderItemDAO(this, item)).forEach(orderItems::add);
    }
}
