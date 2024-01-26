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
@Table(
        name = "student" ,
        uniqueConstraints = @UniqueConstraint(
            name = "email_unique",
            columnNames = "student-email"
        )
)
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Column (name = "student-id")
    private long studentId;
    @Column (name = "student-firstName")
    private String studentFistName;
    @Column (name = "student-lastName")
    private String studentLastName;
    @Column (name = "student-email" ,nullable = false, unique = true)
    private String studentEmail;

}
