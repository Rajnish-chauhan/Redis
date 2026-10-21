package com.rajnishsystems.in.redis.dao;
import org.apache.catalina.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {

    private final RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "USER312412";

    // Constructor Injection
    public UserDao(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public User save(User user) {
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    }

    public User get(String userId) {
        return (User) redisTemplate.opsForHash().get(KEY, userId);
    }

    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    public void delete(String userId) {
        redisTemplate.opsForHash().delete(KEY, userId);
    }
}