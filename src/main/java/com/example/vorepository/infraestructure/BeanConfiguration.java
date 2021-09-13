package com.example.vorepository.infraestructure;

import com.example.vorepository.domain.repository.OrderRepository;
import com.example.vorepository.domain.service.DomainOrderService;
import com.example.vorepository.domain.service.OrderService;
import com.example.vorepository.infraestructure.postgres.SQLOrderRepository;
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
