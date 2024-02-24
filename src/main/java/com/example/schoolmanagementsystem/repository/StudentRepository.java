package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.model.Guardian;
import com.example.schoolmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.security.Guard;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {



    List<Student> findByStudentFistName(String firstName);

    List<Student> findByStudentFistNameContaining(String Arg);
    List<Student> findAllByGuardian(Guardian guardian);




    // creating custom queries JPQL


    //get student by email
    @Query("select s from Student s WHERE s.studentEmail = ?1")
    Student getStudentByStudentEmail(String s);

    //get student's first name by email
    @Query("select s.studentFistName from Student s WHERE s.studentEmail = ?1")
    String getStudentFirstNameByStudentEmail(String s);




    // creating native queries -----------------

    //get student name by email

    @Query(
            value = "select * from student s where s.student_email = ?1 ",
            nativeQuery = true
    )
    Student getStudentByStudentEmailNative(String email);


    //get student name by email

    @Query(
            value = "select * from student s where s.student_email = :email ",
            nativeQuery = true
    )
    Student getStudentByStudentEmailNativeNamedParam(
            @Param("email") String email
    );



    // update the data
    @Modifying
    @Transactional
    @Query(value =
            "update student s set s.student_first_name= :first, s.student_last_name= :last  where  s.student_email = :email"
            ,nativeQuery = true)
    int  updateStudentNameByEmailId(
            @Param("first") String firstName,
            @Param("last") String lastName,
            @Param("email") String emailId
    );






}
