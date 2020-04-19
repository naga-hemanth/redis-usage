package com.hemanth.redisusage.service;

import com.hemanth.redisusage.dao.InstructorRepositoryImpl;
import com.hemanth.redisusage.model.Instructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InstrctorService {
    @Autowired
    private InstructorRepositoryImpl instructorRepository;

    public Boolean instructorExists(String name){
        if(instructorRepository.findByName(name)!=null){
            return true;
        }
        return false;
    }

    public Boolean fingIflicensed(String name){
        if(instructorRepository.findLicense(name)!=null){
            return true;
        }
        return false;
    }

    public void saveInstructor(Instructor instructor){
        instructorRepository.save(instructor);
    }
    public Instructor findByName(String name){
        return instructorRepository.findByName(name);
    }

    public void updateDetails(Instructor instructor){
        instructorRepository.update(instructor);
    }
    public void delete(String instructorName){
        instructorRepository.delete(instructorName);
    }
}
