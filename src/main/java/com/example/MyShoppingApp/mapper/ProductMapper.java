package com.example.MyShoppingApp.mapper;

import com.example.MyShoppingApp.dto.ProductDTO;
import com.example.MyShoppingApp.entity.Category;
import com.example.MyShoppingApp.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO toDto(Product product)
    {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()

        );
    }

    public Product toEntity(ProductDTO productDTO, Category category)
    {
         return Product.builder()
                 .name(productDTO.getName())
                 .description(productDTO.getDescription())
                 .price(productDTO.getPrice())
                 .category(category)
                  .build();
    }

}
