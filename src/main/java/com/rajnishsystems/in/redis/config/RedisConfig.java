package com.rajnishsystems.in.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        // connection Factory
        redisTemplate.setConnectionFactory(connectionFactory);

        // key serializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // value serializer
        ObjectMapper objectMapper = new ObjectMapper();
        redisTemplate.setValueSerializer(new GenericJacksonJsonRedisSerializer(objectMapper));

        return redisTemplate;
    }
}