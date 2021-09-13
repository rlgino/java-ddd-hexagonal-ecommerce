package com.example.vorepository.infraestructure.postgres;

import com.example.vorepository.domain.Order;
import com.example.vorepository.domain.Product;
import com.example.vorepository.domain.repository.OrderRepository;
import com.example.vorepository.infraestructure.postgres.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Component("postgresRepository")
public class PostgresDBOrderRepository implements OrderRepository {

    private final SQLOrderRepository sqlOrderRepository;
    private final SQLOrderItemRepository sqlOrderItemRepository;

    @Autowired
    public PostgresDBOrderRepository(SQLOrderRepository sqlOrderRepository, SQLOrderItemRepository sqlOrderItemRepository) {
        this.sqlOrderRepository = sqlOrderRepository;
        this.sqlOrderItemRepository = sqlOrderItemRepository;
    }

    @Override
    public Optional<Order> findById(UUID id) {
        final Optional<OrderDAO> orderDTO = sqlOrderRepository.findById(id.toString());
        if (orderDTO.isPresent()) {
            final OrderDAO orderDAO = orderDTO.get();
            final Order result = new Order(UUID.fromString(orderDAO.getID()), new Product(UUID.randomUUID(), BigDecimal.TEN, "hola"));
            return Optional.of(result);
        }
        return Optional.empty();
    }

    @Override
    public void save(Order order) {
        final OrderDAO orderDAO = new OrderDAO(order);
        sqlOrderRepository.save(orderDAO);
    }
}
