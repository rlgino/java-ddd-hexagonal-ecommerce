package com.example.vorepository.infraestructure;

import com.example.vorepository.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SpringDataMongoOrderRepository extends MongoRepository<Order, UUID> {
}
