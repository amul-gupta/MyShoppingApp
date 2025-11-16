package com.example.MyShoppingApp.service;

import com.example.MyShoppingApp.entity.User;
import com.example.MyShoppingApp.repository.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //create
    public User create(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRespository.save(user);
    }

    //update


    //delete
    public void delete(String username)
    {
         User user = userRespository.findByUsername(username).get();
         userRespository.delete(user);
    }

    //get all
    public List<User> getAll()
    {
        return userRespository.findAll();
    }


    //get by username
    public User getByUsername(String username)
    {
        return userRespository.findByUsername(username).get();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRespository.findByUsername(username);
        if(user.isPresent())
        {
            return null;
        }
        else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
