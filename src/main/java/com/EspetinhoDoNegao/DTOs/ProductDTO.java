package com.EspetinhoDoNegao.DTOs;

import java.math.BigDecimal;

import com.EspetinhoDoNegao.domain.entitys.ProductType;

public record ProductDTO(String name, String description, BigDecimal price, ProductType productType) {
}
