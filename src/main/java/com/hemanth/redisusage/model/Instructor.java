package com.hemanth.redisusage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor implements Serializable {
    private String name;
    private HashMap<String, String> details;
}
