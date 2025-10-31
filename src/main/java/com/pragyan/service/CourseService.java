package com.pragyan.service;


import com.pragyan.entity.Course;
import com.pragyan.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CourseService {
    private final CourseRepository repo;
    public CourseService(CourseRepository repo){ this.repo=repo; }
    public Course create(Course c){ return repo.save(c); }
    public List<Course> all(){ return repo.findAll(); }
    public Course get(Long id){ return repo.findById(id).orElse(null); }
    public void delete(Long id){ repo.deleteById(id); }
}
