package com.example.redis.repository;

import com.example.redis.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private RedisTemplate<String,User> redisTemplate;
    private HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate<String,User> redisTemplate)
    {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public String userAdd(User user) {
        hashOperations.put("USER",user.getId(),user);
        return "User Added Successfully";
    }

    @Override
    public Map<Integer,User> getAllUsers() {
        return hashOperations.entries("USER");
    }

    @Override
    public String deleteUser(int userId) {
        hashOperations.delete("USER",userId);
        return "User deleted Successfully";
    }

    @Override
    public User getUserById(int id) {
        return (User) hashOperations.get("USER",id);
    }
}
