package com.rajnishsystems.in.redis.controllers;

import com.rajnishsystems.in.redis.dao.UserDao;
import com.rajnishsystems.in.redis.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users/**")
public class UserController {

    private final UserDao userDao;

    // Constructor Injection
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("create")
    public User createUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("getUser/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userDao.get(userId);
    }


    @GetMapping("getAllusers")
    public List<User> getAll() {
        // Modern Java stream collection
        return userDao.findAll().values().stream()
                .map(value -> (User) value)
                .toList();
    }


    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userDao.delete(userId);
    }
}