package com.pragyan.service;

import com.pragyan.repository.CourseRepository;
import com.pragyan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MatrixService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;

    public Map<String, Long> count(){
       long usersCt= userRepository.countUser();
        long courseCt= courseRepository.courseCount();
        Map<String,Long> mapCount= new HashMap<>();
        mapCount.put("usercount",usersCt);
        mapCount.put("coursecount",courseCt);
        return mapCount;
    }
}
