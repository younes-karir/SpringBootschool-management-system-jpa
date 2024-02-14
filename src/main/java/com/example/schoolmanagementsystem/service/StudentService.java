package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {


    String createStudent(Student student);
    List<Student> getAllStudent();

    Student getStudent(Long id);


}
