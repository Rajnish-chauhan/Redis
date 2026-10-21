package com.rajnishsystems.in.redis.controllers;

import com.rajnishsystems.in.redis.dao.UserDao;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    // Constructor Injection
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userDao.get(userId);
    }

    @GetMapping
    public List<User> getAll() {
        // Modern Java stream collection
        return userDao.findAll().values().stream()
                .map(value -> (User) value)
                .toList();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userDao.delete(userId);
    }
}