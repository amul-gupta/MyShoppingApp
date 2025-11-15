package com.example.MyShoppingApp.controller;


import com.example.MyShoppingApp.entity.Category;
import com.example.MyShoppingApp.entity.Product;
import com.example.MyShoppingApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //create
    @PostMapping("/create/{name}")
    public ResponseEntity<Product> create(@RequestBody Product product, @PathVariable String name)
    {
        return new ResponseEntity<>(productService.create(product,name), HttpStatus.CREATED);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable String id)
    {
        return new ResponseEntity<>(productService.update(product,id), HttpStatus.ACCEPTED);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id)
    {
        productService.delete(id);
        return new ResponseEntity<>("product deleted successfully", HttpStatus.OK);
    }

    //get all
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAll()
    {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    //get by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id)
    {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

}
