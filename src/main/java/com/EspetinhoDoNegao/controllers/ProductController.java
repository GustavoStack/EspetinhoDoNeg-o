package com.EspetinhoDoNegao.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EspetinhoDoNegao.DTOs.ProductDTO;
import com.EspetinhoDoNegao.domain.entitys.Products;
import com.EspetinhoDoNegao.services.ProductsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsService productsService;


    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody ProductDTO productDTO) {
        Products product = this.productsService.createProduct(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts(){
        List<Products> products = this.productsService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
}
