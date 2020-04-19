package com.hemanth.redisusage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisUsageApplication  {
    @Autowired
    RedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RedisUsageApplication.class, args);
    }

}
