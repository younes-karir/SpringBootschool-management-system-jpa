package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Teacher findTeacherByEmail(String email);
}
