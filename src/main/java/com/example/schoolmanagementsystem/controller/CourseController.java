package com.example.schoolmanagementsystem.controller;


import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.response.ResponseHandler;
import com.example.schoolmanagementsystem.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

     CourseService courseService;

    @PostMapping
    public ResponseEntity<Object> createCourse(@RequestBody Course course){


        return ResponseHandler.responseBuilder(
                "course created",
                HttpStatus.CREATED,
                courseService.createCourse(course)

        );
    }


}
