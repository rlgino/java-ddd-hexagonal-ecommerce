package com.example.rlgino.infraestructure.mongo;

import com.example.rlgino.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SpringDataMongoOrderRepository extends MongoRepository<Order, UUID> {
}
