package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.advice.exceptions.ElementNotFoundException;
import com.example.schoolmanagementsystem.advice.exceptions.ExistedElementException;
import com.example.schoolmanagementsystem.dto.StudentRequest;
import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.model.Guardian;
import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.repository.StudentRepository;
import com.example.schoolmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl  implements StudentService {


    StudentRepository studentRepository;

    @Override
    public Student createStudent(StudentRequest studentRequest) {

        if(studentRepository.getStudentByStudentEmail(studentRequest.getStudentEmail()) != null)
            throw  new ExistedElementException("duplicated email");

        Student student = Student.builder()
                .studentEmail(studentRequest.getStudentEmail())
                .studentLastName(studentRequest.getStudentLastName())
                .studentFistName(studentRequest.getStudentFistName())
                .guardian(Guardian.builder()
                        .email(studentRequest.getGuardian().getEmail())
                        .name(studentRequest.getGuardian().getName())
                        .phoneNumber(studentRequest.getGuardian().getPhoneNumber())
                        .build())
                .build();
        return  studentRepository.save(student);
    }

    @Override
    public Student updateStudent(StudentRequest studentRequest,Long id) {
        if(studentRepository.findById(id).isEmpty())
            throw  new ElementNotFoundException("student not found");
        else {
            Student student = Student.builder()
                    .studentId(id)
                    .studentEmail(studentRequest.getStudentEmail())
                    .studentLastName(studentRequest.getStudentLastName())
                    .studentFistName(studentRequest.getStudentFistName())
                    .guardian(Guardian.builder()
                            .email(studentRequest.getGuardian().getEmail())
                            .name(studentRequest.getGuardian().getName())
                            .phoneNumber(studentRequest.getGuardian().getPhoneNumber())
                            .build())
                    .build();
            return studentRepository.save(student);
        }
    }

    @Override
    public Student removeStudent(Long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        if(studentRepository.findById(id).isEmpty())
            throw  new ElementNotFoundException("student not found");
        return studentRepository.findById(id).get();
    }


}
