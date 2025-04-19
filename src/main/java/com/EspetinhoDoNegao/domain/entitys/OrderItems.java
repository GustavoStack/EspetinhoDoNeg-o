package com.EspetinhoDoNegao.domain.entitys;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    @Id
    private String productId;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private String complements;
}
