package com.example.schoolmanagementsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "student-id")
    private long studentId;
    @Column (name = "student-first-name")
    private String studentFistName;
    @Column (name = "student-last-name")
    private String studentLastName;
    @Column (name = "student-email")
    private String studentEmail;

}
