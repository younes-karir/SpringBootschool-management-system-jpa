package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Guardian;
import com.example.schoolmanagementsystem.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Guard;
import java.util.List;

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
                //.guardianName("sup")
                //.guardianEmail("sup@gmail.com")
                //.guardianPhoneNumber("066034234")
                .build();

        studentRepository.save(item);
    }


    @Test
    public void createStudentWithGuardian(){
        Guardian guardian  = Guardian.builder()
                .name("Salah AHN")
                .email("salah@gmail.com")
                .phoneNumber("045467567")
                .build();

        Student student = Student.builder()
                .studentFistName("yousra")
                .studentLastName("hatim")
                .studentEmail("yousra@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }



    @Test
    public void getAllStudent(){
        List<Student> data = studentRepository.findAll();

        for (Student item: data) {
            System.out.println(item.toString());
        }
    }


    @Test
    public void getStudent(){
        List<Student> data  = studentRepository.findByStudentFistName("younes");
        for (Student item: data) {
            System.out.println(item.toString());
        }

    }


    @Test
    public void getStudentContain(){
        List<Student> data  = studentRepository.findByStudentFistNameContaining("you");
        System.out.println("-------------------------- testing ---------------------------\n");
        for (Student item: data) {
            System.out.println(item.toString());
        }
        System.out.println("-------------------------- testing ---------------------------\n");

    }




    @Test
    public void getStudentsByGuardian(){
        Guardian guardian  = Guardian.builder()
                .name("Ahmed AHN")
                .phoneNumber("05673213123")
                .email("sup@gmail.com")
                .build();

        List<Student> data = studentRepository.findAllByGuardian(guardian);

        System.out.println("-------------------------- testing ---------------------------\n");
        for (Student item: data) {
            System.out.println(item.toString());
        }
        System.out.println("-------------------------- testing ---------------------------\n");

    }



}