package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {


    @Autowired
    CourseRepository courseRepository;





    @Test
    public void getAllCourses(){
        List<Course> data = courseRepository.findAll();
        System.out.println("courses = " + data); // after adding the courseMaterial inside course

    }


}