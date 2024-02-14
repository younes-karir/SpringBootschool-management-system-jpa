package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.repository.StudentRepository;
import com.example.schoolmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl  implements StudentService {


    StudentRepository studentRepository;

    @Override
    public String createStudent(Student student) {
        studentRepository.save(student);
        return "Student created with success";
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

}
