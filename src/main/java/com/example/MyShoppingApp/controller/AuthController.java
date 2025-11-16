package com.example.MyShoppingApp.controller;

import com.example.MyShoppingApp.entity.User;
import com.example.MyShoppingApp.security.CustomUserDetailsService;
import com.example.MyShoppingApp.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        // Authenticate user
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        // Load user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        // Generate JWT token
        String token = jwtUtil.generateToken(userDetails);

        // Return token
        return Map.of("token", token);
    }


}
