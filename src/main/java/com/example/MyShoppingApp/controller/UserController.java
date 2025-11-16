package com.example.MyShoppingApp.controller;


import com.example.MyShoppingApp.entity.User;
import com.example.MyShoppingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //create
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }


    //update

    //delete
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> delete(@PathVariable String username)
    {
        userService.delete(username);
        return new ResponseEntity<>("user record deletd successfully", HttpStatus.OK);
    }

    //get all
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll()
    {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    //get by username
    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username)
    {
        return new ResponseEntity<>(userService.getByUsername(username), HttpStatus.CREATED);
    }

}
