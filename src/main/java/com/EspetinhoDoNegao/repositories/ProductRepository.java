package com.EspetinhoDoNegao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.EspetinhoDoNegao.domain.entitys.Products;

public interface ProductRepository extends MongoRepository<Products, String> {
    
}
