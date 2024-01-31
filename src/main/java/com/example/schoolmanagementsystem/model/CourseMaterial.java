package com.example.schoolmanagementsystem.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = "course")
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

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "courseId",
            referencedColumnName = "courseId"
    )
    private Course course;


}
