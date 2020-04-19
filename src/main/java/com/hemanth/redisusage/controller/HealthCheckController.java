package com.hemanth.redisusage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthCheckController {
    @Value("${spring.redis.host=redis}")
    private  String str;
    @RequestMapping(value="/health")
    public ResponseEntity<String> healthCheck(){
log.info(str);
        return  ResponseEntity.ok().body("Good to go!");
    }
}