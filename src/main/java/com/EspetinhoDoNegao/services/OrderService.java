package com.EspetinhoDoNegao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EspetinhoDoNegao.DTOs.OrderDTO;
import com.EspetinhoDoNegao.DTOs.OrderItemDTO;
import com.EspetinhoDoNegao.domain.entitys.Order;
import com.EspetinhoDoNegao.domain.entitys.OrderItems;
import com.EspetinhoDoNegao.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order createOrder(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.id());
        order.setClient(dto.client());

        List<OrderItems> items = dto.items().stream().map(itemDto -> {
            OrderItems item = new OrderItems();
            item.setProductId(itemDto.productId());
            item.setName(itemDto.name());
            item.setPrice(itemDto.price());
            item.setQuantity(itemDto.quantity());
            item.setComplements(itemDto.complements());
            return item;
        }).toList();

        order.setItems(items);
        saveOrder(order);
        return order;
    }
}
