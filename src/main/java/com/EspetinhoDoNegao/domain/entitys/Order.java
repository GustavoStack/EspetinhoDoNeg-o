package com.EspetinhoDoNegao.domain.entitys;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String client;
    private List<OrderItems> items;
    private String street;
    private String number;
    private String neighborhood;
    private String phoneNumber;
    private List<Change> change;
    private String status;
    private String methodPayment;
    private BigDecimal totalPrice;
}
