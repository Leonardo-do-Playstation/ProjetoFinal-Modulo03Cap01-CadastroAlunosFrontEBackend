
package com.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Student;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {

    public List<Student> students = new ArrayList<>();

    public StudentController() {

        students.add(new Student(1, "Jonas Silva", "jonas.silva@email.com", "11987654321", 1, 1));
        students.add(new Student(2, "Maria Souza", "maria.souza@email.com", "11976543210", 2, 3));
        students.add(new Student(3, "João Pereira", "joao.pereira@email.com", "11965432109", 1, 2));
        students.add(new Student(4, "Ana Costa", "ana.costa@email.com", "11954321098", 3, 2));
        students.add(new Student(5, "Lucas Martins", "lucas.martins@email.com", "11943210987", 2, 3));

    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        int maxId = students.stream()
                .mapToInt(Student::getId)
                .max()
                .orElse(0);

        student.setId(maxId + 1);
        students.add(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

}
