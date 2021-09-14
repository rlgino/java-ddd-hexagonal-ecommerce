package com.example.rlgino.infraestructure.postgres.dao;

import com.example.rlgino.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItemDAO {
    @Id
    private String id;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderDAO orderID;

    public OrderItemDAO(OrderDAO order, OrderItem item) {
        this.id = item.getId().toString();
        this.price = item.getPrice();
        this.orderID = order;
    }
}
