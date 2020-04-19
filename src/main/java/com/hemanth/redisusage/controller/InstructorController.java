package com.hemanth.redisusage.controller;

import com.hemanth.redisusage.dao.InstructorRepositoryImpl;
import com.hemanth.redisusage.model.Instructor;
import com.hemanth.redisusage.service.InstrctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "instructor")
@Slf4j
public class InstructorController {
    @Autowired
    private InstructorRepositoryImpl instructorRepository;

    @Autowired
    private InstrctorService instrctorService;
    @PostMapping("save_details")
    ResponseEntity<String> saveInstructor(@RequestBody Instructor instructor) {
        log.info("Request for data save came for " + instructor);
        instrctorService.saveInstructor(instructor);
        return ResponseEntity.ok().body("Data Saved!");
    }

    @GetMapping("/get_details/{name}")
    ResponseEntity<Instructor> getInstructor(@PathVariable("name") String instructorName) {
        log.info("Request for get Instructor came with " + instructorName);
        return ResponseEntity.ok().body(instrctorService.findByName(instructorName));
    }

    @PatchMapping("update_details")
    ResponseEntity<String> updateInstructor(@RequestBody Instructor instructor) {
        log.info("Request for update Instructor came with " + instructor);
        instrctorService.updateDetails(instructor);
        return ResponseEntity.ok().body("Data Updated");
    }

    @DeleteMapping("delete/{name}")
    ResponseEntity<String> deleteInstructor(@PathVariable("name") String instructorName) {
        log.info("Request for delete Instructor came with " + instructorName);
        instructorRepository.delete(instructorName);
        return ResponseEntity.ok().body("Deleted");
    }
}
