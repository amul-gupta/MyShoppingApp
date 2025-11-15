package com.example.MyShoppingApp.dto;

import com.example.MyShoppingApp.entity.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private String id;

    private String name;

    private String description;

    private Double price;

    private String categoryid;

}
