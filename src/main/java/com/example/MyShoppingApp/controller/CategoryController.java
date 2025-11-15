package com.example.MyShoppingApp.controller;

import com.example.MyShoppingApp.dto.CategoryDTO;
import com.example.MyShoppingApp.entity.Category;
import com.example.MyShoppingApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category)
    {
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable String id)
    {
        return new ResponseEntity<>(categoryService.update(category,id),HttpStatus.ACCEPTED);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id)
    {
        categoryService.delete(id);
        return new ResponseEntity<>("category deleted successfully",HttpStatus.OK);
    }


    //get all
    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAll()
    {
        return new ResponseEntity<>(categoryService.getAll(),HttpStatus.OK);
    }


    //get by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Category> update(@PathVariable String id)
    {
        return new ResponseEntity<>(categoryService.getById(id),HttpStatus.OK);
    }
}
