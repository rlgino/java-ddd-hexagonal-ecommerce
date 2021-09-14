package com.example.rlgino.infraestructure.postgres;

import com.example.rlgino.infraestructure.postgres.dao.OrderDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SQLOrderRepository extends CrudRepository<OrderDAO, String> {
}
