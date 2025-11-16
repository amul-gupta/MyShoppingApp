package com.example.MyShoppingApp.controller;

import com.example.MyShoppingApp.dto.CategoryDTO;
import com.example.MyShoppingApp.entity.Category;
import com.example.MyShoppingApp.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "Category",
        description = "REST APIs"
)

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //create
    @Operation(
            summary = "create category",
            description = "Rest API to create category"

    )
    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category)
    {
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    //update
    @Operation(
            summary = "update category",
            description = "Rest API to update category"

    )
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable String id)
    {
        return new ResponseEntity<>(categoryService.update(category,id),HttpStatus.ACCEPTED);
    }

    //delete
    @Operation(
            summary = "delete category",
            description = "Rest API to delete category"

    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id)
    {
        categoryService.delete(id);
        return new ResponseEntity<>("category deleted successfully",HttpStatus.OK);
    }


    //get all
    @Operation(
            summary = "get all category",
            description = "Rest API to get all category"

    )
    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAll()
    {
        return new ResponseEntity<>(categoryService.getAll(),HttpStatus.OK);
    }


    //get by id
    @Operation(
            summary = "get by id category",
            description = "Rest API to get by id category"

    )
    @GetMapping("/getById/{id}")
    public ResponseEntity<Category> update(@PathVariable String id)
    {
        return new ResponseEntity<>(categoryService.getById(id),HttpStatus.OK);
    }
}
