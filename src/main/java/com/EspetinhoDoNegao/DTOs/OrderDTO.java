package com.EspetinhoDoNegao.DTOs;

import java.util.List;


public record OrderDTO(String id,String client, List<OrderItemDTO> items) {
}
