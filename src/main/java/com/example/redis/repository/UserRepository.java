package com.example.redis.repository;

import com.example.redis.model.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    public String userAdd(User user);
    public Map<Integer,User> getAllUsers();
    public String deleteUser(int userId);
    public User getUserById(int id);
}
