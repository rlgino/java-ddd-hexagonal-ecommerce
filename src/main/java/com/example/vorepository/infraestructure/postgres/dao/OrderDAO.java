package com.example.vorepository.infraestructure.postgres.dao;

import com.example.vorepository.domain.Order;
import com.example.vorepository.domain.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Entity(name = "ORDERS")
public class OrderDAO {
    @Id
    private String ID;
    private OrderStatus status;
    private BigDecimal price;


    public OrderDAO(Order order) {
        ID = order.getId().toString();
        status = order.getStatus();
        price = order.getPrice();
    }
}
