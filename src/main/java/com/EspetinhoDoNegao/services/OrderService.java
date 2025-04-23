package com.EspetinhoDoNegao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EspetinhoDoNegao.DTOs.OrderDTO;
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
        order.setNumber(dto.number());
        order.setStreet(dto.street());
        order.setNeighborhood(dto.neighborhood());
        order.setPhoneNumber(dto.phoneNumber());
        order.setMethodPayment(dto.methodPayment());
        order.setStatus("Em_andamento");

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

    //upadate order status
    public Order updateOrderStatus(String id, String status) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
