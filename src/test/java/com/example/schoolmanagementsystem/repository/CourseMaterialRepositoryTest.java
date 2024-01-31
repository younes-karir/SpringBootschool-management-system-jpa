package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.model.CourseMaterial;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;


    @Test
    public  void courseMaterial() {
        Course course = Course.builder()
                .courseTitle("JAVA learnings")
                .credit(10)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }



    @Test
    public void printAllCourses () {
        List<CourseMaterial> DATA = courseMaterialRepository.findAll();
        System.out.println("-------------> " + DATA);
    }

}