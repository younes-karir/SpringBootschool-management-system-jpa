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
@Table(name = "course-material")
public class CourseMaterial {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseMaterialSequence"
    )
    @SequenceGenerator(
            name = "courseMaterialSequence",
            sequenceName = "courseMaterialSequence",
            allocationSize = 1
    )
    @Column(name = "courseMaterialId")
    private Long courseMaterialId;

    @Column(name = "courseMaterialUrl")
    private String url;

    @OneToOne
    @JoinColumn(
            name = "courseId",
            referencedColumnName = "courseId"

    )
    private Course course;


}
