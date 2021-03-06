package com.hemanth.redisusage.model;

import com.hemanth.redisusage.model.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    private String name;
    private Instructor instructor;
    private Double rating;
    private List<String> lectures;
}
