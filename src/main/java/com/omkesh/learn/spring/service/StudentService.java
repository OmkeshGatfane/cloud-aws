package com.omkesh.learn.spring.service;

import com.omkesh.learn.spring.entity.Laptop;
import com.omkesh.learn.spring.entity.Student;
import com.omkesh.learn.spring.repositries.LaptopRepository;
import com.omkesh.learn.spring.repositries.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final LaptopRepository laptopRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, LaptopRepository laptopRepository) {
        this.studentRepository = studentRepository;
        this.laptopRepository = laptopRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Laptop saveLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

}
