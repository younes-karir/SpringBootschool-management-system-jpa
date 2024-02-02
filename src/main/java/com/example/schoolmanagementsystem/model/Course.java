package com.example.schoolmanagementsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseSequence"
    )
    @SequenceGenerator(
            name = "courseSequence",
            sequenceName = "courseSequence",
            allocationSize = 1
    )
    @Column(name = "courseId")
    private Long courseId;

    @Column(name = "courseTitle")
    private String courseTitle;

    @Column(name = "courseCredit")
    private Integer credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

}
