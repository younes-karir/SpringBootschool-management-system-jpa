package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.model.CourseMaterial;
import com.example.schoolmanagementsystem.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {


    @Autowired
    TeacherRepository teacherRepository;



    @Test
    public void createTeacher(){
        Teacher teacher
                = Teacher.builder()
                .lastName("Dahmane")
                .firstName("Khalid")
                .build();

        teacherRepository.save(teacher);

    }

}