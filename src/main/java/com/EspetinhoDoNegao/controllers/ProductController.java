package com.EspetinhoDoNegao.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.EspetinhoDoNegao.DTOs.ProductDTO;
import com.EspetinhoDoNegao.domain.entitys.Products;
import com.EspetinhoDoNegao.services.ProductsService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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

    private static final String UPLOAD_DIR = "uploads/";


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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR, fileName);
        Files.createDirectories(path.getParent());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        String imageUrl = "http://localhost:8090/uploads/" + fileName;
        return ResponseEntity.ok(imageUrl);
    }
    
}
