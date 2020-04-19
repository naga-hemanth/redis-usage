package com.hemanth.redisusage.dao;

import com.hemanth.redisusage.model.Course;

import java.util.Set;

public interface CourseRepository {
    void save(Course course);
    Course findByName(String name);
    void update(Course course);
    Set findAll();
    void  delete(String name);
    Set  getInRatingRange(Double min,Double max);
}
