package com.EspetinhoDoNegao.domain.entitys;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.EspetinhoDoNegao.DTOs.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Products {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private ProductType productType;
    private String imageUrl;



    public Products(ProductDTO productDTO) {
        this.name = productDTO.name();
        this.description = productDTO.description();
        this.price = productDTO.price();
        this.productType = productDTO.productType();
        this.imageUrl = productDTO.imageUrl();
    }

    public ProductType convertToEnum(ProductType productType) {
        if(productType == null) {
            return null;
        }
        String productTypeString = productType.toString();
        switch (productTypeString) {
            case "DRINK_TYPE":
                return ProductType.DRINK_TYPE;
            case "FOOD_TYPE":
                return ProductType.FOOD_TYPE;
            case "ACCOMPANIMENT_TYPE":
                return ProductType.ACCOMPANIMENT_TYPE;
            case "BEER_TYPE":
                return ProductType.BEER_TYPE;
            default:
                throw new IllegalArgumentException("Invalid product type: " + productTypeString);
        }
    }
}
