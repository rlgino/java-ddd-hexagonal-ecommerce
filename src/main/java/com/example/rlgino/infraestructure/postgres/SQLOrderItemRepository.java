package com.example.rlgino.infraestructure.postgres;

import com.example.rlgino.infraestructure.postgres.dao.OrderItemDAO;
import org.springframework.data.repository.CrudRepository;

public interface SQLOrderItemRepository extends CrudRepository<OrderItemDAO, String> {
}
