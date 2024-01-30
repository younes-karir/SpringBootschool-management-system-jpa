package com.example.schoolmanagementsystem.controller;


import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.service.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    StudentServiceImpl studentService;

    @GetMapping("/all")
    public List<Student> getAll(){
        return studentService.getAllStudent();
    }




}
