package com.example.vorepository.infraestructure;

import com.example.vorepository.domain.repository.OrderRepository;
import com.example.vorepository.domain.service.DomainOrderService;
import com.example.vorepository.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    OrderService orderService(OrderRepository repo) {
        return new DomainOrderService(repo);
    }
}
