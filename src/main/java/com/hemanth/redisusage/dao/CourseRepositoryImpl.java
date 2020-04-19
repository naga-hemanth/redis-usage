package com.hemanth.redisusage.dao;

import com.hemanth.redisusage.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @Autowired
    RedisTemplate redisTemplate;

    private String commonKey="COURSE";

    @Override
    public void save(Course course) {
        redisTemplate.opsForZSet().add(commonKey,course,course.getRating());
    }

    @Override
    public Course findByName(String name) {
       return (Course) redisTemplate.opsForHash().get(commonKey,name);
    }

    @Override
    public void update(Course course) {
        save(course);
    }

    @Override
    public Set findAll() {
      return redisTemplate.opsForZSet().rangeByScore(commonKey, Double.MIN_VALUE, Double.MAX_VALUE);

    }

    @Override
    public void delete(String name) {
       redisTemplate.opsForHash().delete(commonKey,name);
    }

    @Override
    public Set getInRatingRange(Double min,Double max) {
        return redisTemplate.opsForZSet().rangeByScore(commonKey,min,max);
    }

    public Long findrank(Course course){
        return redisTemplate.opsForZSet().rank(commonKey,course);
    }

}
