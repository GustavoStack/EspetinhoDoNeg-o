package com.EspetinhoDoNegao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.EspetinhoDoNegao.domain.entitys.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
