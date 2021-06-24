package com.example.vorepository.domain.service;

import com.example.vorepository.domain.Order;
import com.example.vorepository.domain.Product;
import com.example.vorepository.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DomainOrderServiceUnitTest {

    private OrderRepository orderRepository;
    private DomainOrderService tested;

    @BeforeEach
    void setup(){
        orderRepository = mock(OrderRepository.class);
        tested = new DomainOrderService(orderRepository);
    }

    @Test
    void sholdCreateOrder_ThenSaveIt() {
        final Product prod = new Product(UUID.randomUUID(), BigDecimal.TEN, "Prod name");
        final UUID id = UUID.randomUUID();

        tested.createOrder(id, prod);

        verify(orderRepository).save(any(Order.class));
    }
}
