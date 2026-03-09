package com.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Course;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {

    public List<Course> courses = new ArrayList<>();

    public CourseController() {
        courses.add(new Course(1, "Java"));
        courses.add(new Course(2, "Angular"));
        courses.add(new Course(3, "C#"));
        courses.add(new Course(4, "Python"));
        courses.add(new Course(5, "JavaScript"));
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courses;
    }

}
