package com.example.MyShoppingApp.service;

import com.example.MyShoppingApp.dto.CategoryDTO;
import com.example.MyShoppingApp.entity.Category;
import com.example.MyShoppingApp.mapper.CategoryMapper;
import com.example.MyShoppingApp.repository.CategoryRepository;
import com.example.MyShoppingApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //create
    public Category create(Category category)
    {
       return categoryRepository.save(category);

    }

    //update
    public Category update(Category category,String id)
    {
        Category currentCategory = categoryRepository.findById(id).orElseThrow();
        currentCategory.setName(category.getName());
        return categoryRepository.save(currentCategory);

    }


    //delete
    public void delete(String id)
    {
        Category currentCategory = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(currentCategory);
    }


    //get all
    public List<Category> getAll()
    {
        return categoryRepository.findAll();
    }

    //get by id
    public Category getById(String id)
    {
        return categoryRepository.findById(id).orElseThrow();
    }
}
