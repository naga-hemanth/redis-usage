package com.hemanth.redisusage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @RequestMapping(value="/health")
    public ResponseEntity<String> healthCheck(){
        return  ResponseEntity.ok().body("Good to go!");
    }
}