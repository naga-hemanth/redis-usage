package com.hemanth.redisusage.controller;

import com.hemanth.redisusage.model.Course;
import com.hemanth.redisusage.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Slf4j
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(path="/save_details")
    ResponseEntity<Course> saveCourse(@RequestBody Course course) throws Exception {
        log.info("Request for data save came for course " + course);
        Course course1=courseService.saveCourse(course);
        return ResponseEntity.ok().body(course);
    }

    @GetMapping(path = "get_all")
    ResponseEntity<Set> getAllCourses(){
        log.info("Request for get all couses came ");
        return ResponseEntity.ok().body(courseService.getallCourses());
    }

    @GetMapping(path = "rating_range/{min}/{max}")
    ResponseEntity<Set> getInRange(@PathVariable("min") Double min,@PathVariable("max") Double max){
        log.info("Request for get courses in rating range  "+min+"  "+max);
        return ResponseEntity.ok().body( courseService.getAllInRatingRange(min,max));
    }

    @GetMapping(path="/get_rank")
    ResponseEntity<Long> getRank(@RequestBody Course course){
        log.info("Request for get rank of course "+course);
        return ResponseEntity.ok().body(courseService.findrank(course));
    }

}
