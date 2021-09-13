package com.example.vorepository.infraestructure.postgres;

import com.example.vorepository.infraestructure.postgres.dao.OrderItemDAO;
import org.springframework.data.repository.CrudRepository;

public interface SQLOrderItemRepository extends CrudRepository<OrderItemDAO, String> {
}
