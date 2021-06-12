package com.example.redis.controller;

import com.example.redis.model.User;
import com.example.redis.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepositoryImpl userRepository;

    @PostMapping(path = "/addUser")
    private String addUser(@RequestBody User user) { return userRepository.userAdd(user); }

    @GetMapping(path = "/getAllUsers")
    private Map<Integer,User> getAllUsers(){return userRepository.getAllUsers();}

    @DeleteMapping(path = "/deleteUser/{userId}")
    private String deleteUser(@PathVariable int userId){return userRepository.deleteUser(userId);}

    @GetMapping(path = "/getUserById/{userId}")
    private User getUserById(@PathVariable int userId){return userRepository.getUserById(userId);}
}
