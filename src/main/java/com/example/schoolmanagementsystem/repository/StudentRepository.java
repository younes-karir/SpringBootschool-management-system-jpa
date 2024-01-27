package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Guardian;
import com.example.schoolmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Guard;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByStudentFistName(String firstName);

    List<Student> findByStudentFistNameContaining(String Arg);
    List<Student> findAllByGuardian(Guardian guardian);

    List<Student> findByStudentFistNameNotNull(String name);

    List<Student> findByGuardianName(String name);




}
