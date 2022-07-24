package com.example.librarymanagementapplication.controller;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 24-07-2022
 */

import com.example.librarymanagementapplication.exception.UserNotFoundException;
import com.example.librarymanagementapplication.model.User;
import com.example.librarymanagementapplication.repository.UserRepository;
import com.example.librarymanagementapplication.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @PostMapping("/Adduser")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User newUser) throws Exception {
        if(UserValidator.isValid(newUser)){
            return userRepository.save(newUser);
        }
        else throw new Exception();
    }

    @GetMapping("/GetUsersById/{id}")
    User findOne(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
