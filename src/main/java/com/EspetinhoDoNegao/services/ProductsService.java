package com.EspetinhoDoNegao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EspetinhoDoNegao.DTOs.ProductDTO;
import com.EspetinhoDoNegao.domain.entitys.Products;
import com.EspetinhoDoNegao.repositories.ProductRepository;

@Service
public class ProductsService {
    @Autowired
    private ProductRepository productRepository;

    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    public Products createProduct(ProductDTO productDTO){
        Products product = new Products(productDTO);
        this.saveProduct(product);
        return product;
    }

    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }
}
