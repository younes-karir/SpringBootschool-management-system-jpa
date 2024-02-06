package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.model.CourseMaterial;
import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {


    @Autowired
    CourseRepository courseRepository;


    @Test
    public void createCourse(){
        Course course = Course.builder()
                .courseTitle("English")
                .credit(10)
                .teacher(Teacher.builder()
                        .firstName("Adam")
                        .lastName("Amiri")
                        .build())
                .build();

        courseRepository.save(course);


    }


    /*
    @Test
    public void getAllCourses(){
        List<Course> data = courseRepository.findAll();
        System.out.println("courses = " + data); // after adding the courseMaterial inside course

    }
         */



    @Test
    public void getAll(){

        Pageable pageableThreeRecords = PageRequest.of(0,3);
        Pageable pageableTwoRecords = PageRequest.of(1,2);

        Long totalElements =  courseRepository.findAll(pageableTwoRecords).getTotalElements();
        int totalPages =  courseRepository.findAll(pageableTwoRecords).getTotalPages();

        List<Course> data = courseRepository.findAll(pageableTwoRecords).getContent();
        System.out.println("---------------> " + data);
        System.out.println("total elements = " + totalElements);
        System.out.println("total pages = " + totalPages);
    }

    @Test
    public void getAllSortedByTitle () {
        Pageable SortByTitle = PageRequest.of(
                1, 4,
                Sort.by(Sort.Order.asc("courseTitle"))
        );

        Pageable SortByCredit = PageRequest.of(
                1, 4,
                Sort.by(Sort.Order.asc("credit"))
        );

        Pageable SortByTitleAndCredit = PageRequest.of(
                1, 4,
                Sort.by(Sort.Order.asc("credit"))
                        .and(Sort.by(Sort.Order.asc("courseTitle")))
        );

        Long totalElements =  courseRepository.findAll(SortByTitle).getTotalElements();
        int totalPages =  courseRepository.findAll(SortByTitle).getTotalPages();

        List<Course> data = courseRepository.findAll(SortByTitle).getContent();
        System.out.println("total elements = " + totalElements);
        System.out.println("total pages = " + totalPages);

        data.forEach(System.out::println);


    }



    @Test
    public void printFindByCourseTitleContaining(){
        Pageable pageable = PageRequest.of(
                0,2,
                Sort.by(Sort.Order.asc("courseTitle"))
        );

        Page<Course> data = courseRepository.findAllByCourseTitleContainingIgnoreCase("a",pageable);
        List<Course> courses = data.getContent();


        courses.forEach(System.out::println);
    }



    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .lastName("Ahmedi")
                .firstName("Aissa")
                .build();

        Student student = Student.builder()
                .studentFistName("samira")
                .studentLastName("ayami")
                .studentEmail("samira@gmail.com")
                .build();


        Course course = Course.builder()
                .teacher(teacher)
                .courseTitle("Ai")
                .credit(10)
                .build();

        course.addStudent(student);



        courseRepository.save(course);
    }


}