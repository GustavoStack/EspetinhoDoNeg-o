package com.EspetinhoDoNegao.DTOs;

import java.math.BigDecimal;
import java.util.List;


public record OrderDTO(String id,String client, List<OrderItemDTO> items,List<ChangeDTO> change, String street, String number, String neighborhood, String phoneNumber, String methodPayment, BigDecimal totalPrice ) {
}
