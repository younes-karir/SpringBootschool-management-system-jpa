package com.example.schoolmanagementsystem.model;


import jakarta.persistence.*;
import jakarta.validation.Constraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(
        name = "emailUnique",
        columnNames = "teacherEmail"
))
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
    private Long teacherId;
    @Column(name = "teacherFisrtName")
    private String firstName;
    @Column(name = "teacherLastName")
    private String lastName;
    @Column(name = "teacherEmail")
    private String email;

/*
    @OneToMany(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacherId",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses

 */



}
