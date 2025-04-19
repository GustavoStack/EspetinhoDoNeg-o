package com.EspetinhoDoNegao.DTOs;

import java.math.BigDecimal;

public record OrderItemDTO(String productId, String name, Integer quantity, String complements, BigDecimal price) {

}
