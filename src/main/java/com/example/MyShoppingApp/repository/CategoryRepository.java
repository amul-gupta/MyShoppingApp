package com.example.MyShoppingApp.repository;


import com.example.MyShoppingApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

      public Category findByName(String name);
}
