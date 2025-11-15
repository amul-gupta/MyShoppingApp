package com.example.MyShoppingApp.mapper;

import com.example.MyShoppingApp.dto.CategoryDTO;
import com.example.MyShoppingApp.dto.ProductDTO;
import com.example.MyShoppingApp.entity.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category toEnity(CategoryDTO  categoryDTO)
    {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }


    public CategoryDTO toDto(Category category)
    {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .productDTOList(category.getProductList().stream()
                        .map(product -> ProductDTO.builder()
                                .id(product.getId())
                                .name(product.getName())
                                .description(product.getDescription())
                                .price(product.getPrice())
                                .categoryid(product.getId())
                                // map other fields as needed
                                .build())
                        .collect(Collectors.toList()))
                .build();

    }
}
