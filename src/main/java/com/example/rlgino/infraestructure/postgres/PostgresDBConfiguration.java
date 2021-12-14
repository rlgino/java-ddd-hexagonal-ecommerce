package com.example.rlgino.infraestructure.postgres;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.example.vorepository.infraestructure.postgres.dao.*")
@EnableJpaRepositories("com.example.vorepository.infraestructure.postgres.*")
public class PostgresDBConfiguration {
}
