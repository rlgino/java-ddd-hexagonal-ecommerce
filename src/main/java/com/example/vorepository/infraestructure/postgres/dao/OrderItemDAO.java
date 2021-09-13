package com.example.vorepository.infraestructure.postgres.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "ORDER_ITEMS")
public class OrderItemDAO {
    @Id
    private String id;
    private BigDecimal price;
}
