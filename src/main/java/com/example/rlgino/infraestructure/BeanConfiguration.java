package com.example.rlgino.infraestructure;

import com.example.rlgino.domain.repository.OrderRepository;
import com.example.rlgino.domain.service.DomainOrderService;
import com.example.rlgino.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class BeanConfiguration {
    @Bean
    OrderService orderService(OrderRepository postgresRepository) {
        return new DomainOrderService(postgresRepository);
    }
}
