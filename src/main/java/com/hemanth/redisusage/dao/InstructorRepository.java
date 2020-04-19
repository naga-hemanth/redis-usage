package com.hemanth.redisusage.dao;


import com.hemanth.redisusage.model.Instructor;

public interface InstructorRepository {
    void save(Instructor course);
    Instructor findByName(String name);
    void update(Instructor course);
    void  delete(String name);
}
