package com.example.MyShoppingApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String description;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id" , nullable = false)
    @JsonIgnoreProperties("productList")
    private Category category;

}
