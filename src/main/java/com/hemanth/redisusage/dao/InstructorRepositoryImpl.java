package com.hemanth.redisusage.dao;

import com.hemanth.redisusage.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository{

    @Autowired
    private RedisTemplate redisTemplate;

    private String commonKey="INSTRUCTOR";
    private String licenseCommonKey="License";

    @Override
    public void save(Instructor instructor) {
        redisTemplate.opsForHash().put(commonKey,instructor.getName(),instructor);
      redisTemplate.opsForValue().set(licenseCommonKey+instructor.getName(),"present");
        redisTemplate.expire(licenseCommonKey+instructor.getName(),40, TimeUnit.DAYS);
    }

    @Override
    public Instructor findByName(String name) {
        return (Instructor) redisTemplate.opsForHash().get(commonKey,name);
    }

    @Override
    public void update(Instructor instructor) {
        save(instructor);
    }

    @Override
    public void delete(String name) {
        redisTemplate.opsForHash().delete(commonKey,name);
    }

    public String findLicense(String name){
        return (String) redisTemplate.opsForValue().get(licenseCommonKey+name);
    }
}
