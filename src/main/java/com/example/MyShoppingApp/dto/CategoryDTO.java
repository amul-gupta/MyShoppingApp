package com.example.MyShoppingApp.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {

    private String id;

    private String name;

    private List<ProductDTO> productDTOList;
}
