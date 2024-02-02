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
public class Teacher {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Teacher-sequence"
    )
    @SequenceGenerator(
            name = "Teacher-sequence",
            sequenceName = "Teacher-sequence",
            allocationSize = 1
    )
    @Column(name = "teacherId")
    private Long id;
    @Column(name = "teacherFisrtName")
    private String firstName;
    @Column(name = "teacherLastName")
    private String lastName;
}
