package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.StudentRequest;
import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {


    Student createStudent(StudentRequest student);
    List<Student> getAllStudent();

    Student getStudent(Long id);


}
