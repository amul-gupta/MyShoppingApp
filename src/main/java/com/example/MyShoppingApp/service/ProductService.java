package com.example.MyShoppingApp.service;

import com.example.MyShoppingApp.entity.Category;
import com.example.MyShoppingApp.entity.Product;
import com.example.MyShoppingApp.exception.ResourceNotFoundException;
import com.example.MyShoppingApp.repository.CategoryRepository;
import com.example.MyShoppingApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //create
    public Product create(Product product, String name)
    {
        //find the category
        Category category = categoryRepository.findByName(name);
        product.setCategory(category);
        productRepository.save(product);
        return product;
    }

    //update
    public Product update(Product product, String id)
    {
        Product currentProduct = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("product id not found"));
        currentProduct.setName(product.getName());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setPrice(product.getPrice());
        return productRepository.save(currentProduct);
    }


    //delete
    public void delete(String id)
    {
        Product currentProduct = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("product id not found"));
         productRepository.delete(currentProduct);
    }


    //get all
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    //get by id
    public Product getById(String id)
    {
        return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("product id not found"));
    }

}
