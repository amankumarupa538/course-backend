package com.pragyan.controller;


import com.pragyan.entity.Course;
import com.pragyan.service.CourseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    private final CourseService service;
    public CourseController(CourseService service){ this.service=service; }

    @GetMapping public List<Course> all(){ return service.all(); }
    @GetMapping("/{id}") public Course get(@PathVariable Long id){ return service.get(id); }
    @PostMapping public Course create(@RequestBody Course c){ return service.create(c); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}
