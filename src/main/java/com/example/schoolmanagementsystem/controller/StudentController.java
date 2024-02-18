package com.example.schoolmanagementsystem.controller;


import com.example.schoolmanagementsystem.dto.StudentRequest;
import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.response.ResponseHandler;
import com.example.schoolmanagementsystem.service.StudentService;
import com.example.schoolmanagementsystem.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
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

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestBody @Valid StudentRequest student){
         return ResponseHandler.responseBuilder(
                "student details",
                HttpStatus.OK,
                studentService.createStudent(student)
        );
    }


    @PutMapping("{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody @Valid StudentRequest student,@PathVariable Long id){
        return ResponseHandler.responseBuilder(
                "student updated",
                HttpStatus.OK,
                studentService.updateStudent(student,id)
        );
    }



    @DeleteMapping("{id}")
    public ResponseEntity<Object> removeStudent(@PathVariable Long id){


        return ResponseHandler.responseBuilder(
                "student removed",
                HttpStatus.OK,
                studentService.removeStudent(id)
        );
    }







}
