package com.example.rlgino.application.cli;

import com.example.rlgino.domain.Product;
import com.example.rlgino.domain.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class CliOrderController implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(CliOrderController.class);

    private final OrderService orderService;

    @Autowired
    public CliOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createCompleteOrder() {
        LOG.info("<<Create complete order>>");
        UUID orderId = createOrder();
        orderService.completeOrder(orderId);
    }

    public void createIncompleteOrder() {
        LOG.info("<<Create incomplete order>>");
        UUID orderId = createOrder();
    }

    private UUID createOrder() {
        LOG.info("Placing a new order with two products");
        Product mobilePhone = new Product(UUID.randomUUID(), BigDecimal.valueOf(200), "mobile");
        Product razor = new Product(UUID.randomUUID(), BigDecimal.valueOf(50), "razor");
        LOG.info("Creating order with mobile phone");
        UUID orderId = UUID.randomUUID();
        orderService.createOrder(orderId, mobilePhone);
        LOG.info("Adding a razor to the order");
        orderService.addProduct(orderId, razor);
        return orderId;
    }

    @Override
    public void run(String... args) throws Exception {
        createCompleteOrder();
        createIncompleteOrder();
    }
}
