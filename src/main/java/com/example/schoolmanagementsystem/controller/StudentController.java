package com.example.schoolmanagementsystem.controller;


import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.response.ResponseHandler;
import com.example.schoolmanagementsystem.service.StudentService;
import com.example.schoolmanagementsystem.service.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {


    StudentService studentService;


    @GetMapping
    public List<Student> getAll(){
        return studentService.getAllStudent();
    }


    @GetMapping("{id}")
    public ResponseEntity<Object> getStudent(@PathVariable Long id){

        return ResponseHandler.responseBuilder(
                "requested student details are given here ",
                HttpStatus.OK,
                studentService.getStudent(id)
        );
    }




}
