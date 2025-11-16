package com.example.MyShoppingApp.repository;

import com.example.MyShoppingApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User,String> {

    Optional<User> findByUsername(String username);
}
