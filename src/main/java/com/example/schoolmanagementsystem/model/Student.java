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
            columnNames = "studentEmail"
        )
)
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studentSequence"
    )
    @SequenceGenerator(
            name = "studentSequence",
            sequenceName = "studentSequence",
            allocationSize = 1
    )
    @Column (name = "studentId")
    private long studentId;
    @Column (name = "studentFirstName")
    private String studentFistName;
    @Column (name = "studentLastName")
    private String studentLastName;
    @Column (name = "studentEmail" ,nullable = false, unique = true)
    private String studentEmail;
    @Embedded
    private Guardian guardian;
}
