package com.omkesh.learn.spring.controller;

import com.omkesh.learn.spring.entity.Laptop;
import com.omkesh.learn.spring.entity.Student;
import com.omkesh.learn.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students-list")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/laptops-list")
    public ResponseEntity<List<Laptop>> getAllLaptops() {
        List<Laptop> laptops = studentService.getAllLaptops();
        return ResponseEntity.ok(laptops);
    }

    @PostMapping("/save-student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @PostMapping("/save-laptop")
    public ResponseEntity<Laptop> saveLaptop(@RequestBody Laptop laptop) {
        Laptop savedLaptop = studentService.saveLaptop(laptop);
        return ResponseEntity.ok(savedLaptop);
    }
}
