package com.hemanth.redisusage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class redisConfig {

    @Value("${spring.redis.host}")
    private  String host;
    @Bean
    LettuceConnectionFactory lettuceConnectionFactory(){

        //return new LettuceConnectionFactory();
        LettuceConnectionFactory lettuceConnectionFactory
                = new LettuceConnectionFactory();
        lettuceConnectionFactory.setHostName(host);
        lettuceConnectionFactory.setPort(6379);
        return lettuceConnectionFactory;
    }
    @Bean
    RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> template=new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory());
        template.setEnableTransactionSupport(true);
        return template;
    }
}
