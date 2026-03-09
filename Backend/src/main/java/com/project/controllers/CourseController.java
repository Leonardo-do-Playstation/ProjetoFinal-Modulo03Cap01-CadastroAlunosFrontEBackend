package com.project.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Course;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    public List<Course> courses = new ArrayList<>();

    public CourseController() {
        courses.add(new Course(101, "Banco de dados"));
        courses.add(new Course(102, "Programação Orientada a Objetos"));
        courses.add(new Course(103, "Algoritmos"));
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courses;
    }

}
