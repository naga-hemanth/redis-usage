package com.hemanth.redisusage.service;

import com.hemanth.redisusage.model.Course;
import com.hemanth.redisusage.dao.CourseRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class CourseService {
    @Autowired
    private CourseRepositoryImpl courseRepository;

    @Autowired
    private InstrctorService instrctorService;

    public Course saveCourse(Course course) throws Exception {
        log.info("Doing validation on course ");
        if(!instrctorService.instructorExists(course.getInstructor().getName())){
            throw new Exception("Instructor doesnt exist");
        }
        if(!instrctorService.fingIflicensed(course.getInstructor().getName())){
            throw new Exception("Instructor doesnt has license");
        }
        log.info("Done all the validation on course and Inserting");
         courseRepository.save(course);
        return course;
    }
    public Set getallCourses(){
       return  courseRepository.findAll();
    }

    public Set getAllInRatingRange(Double min,Double max){
        return courseRepository.getInRatingRange(min,max);
    }

   public Long findrank(Course course){
        return courseRepository.findrank(course);

   }

}
