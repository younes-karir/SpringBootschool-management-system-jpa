package com.example.schoolmanagementsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            name = "teacherId",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns =  @JoinColumn(
                    name = "student",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;


    public void addStudent(Student student){
        if(students== null) students = new ArrayList<Student>();
        students.add(student);
    }

}
