package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void insertStudent(){
        Student item = Student.builder()
                .studentFistName("younes")
                .studentLastName("karir")
                .studentEmail("youneskarir@gmail.com")
                .guardianName("sup")
                .guardianEmail("sup@gmail.com")
                .guardianPhoneNumber("066034234")
                .build();

        studentRepository.save(item);
    }





    @Test
    public void getStudent(){
        List<Student> data = studentRepository.findAll();

        for (Student item: data) {
            System.out.println(item.toString());
        }
    }


}