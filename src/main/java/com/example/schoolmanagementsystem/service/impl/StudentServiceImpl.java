package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.dto.StudentRequest;
import com.example.schoolmanagementsystem.model.Guardian;
import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.repository.StudentRepository;
import com.example.schoolmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl  implements StudentService {


    StudentRepository studentRepository;

    @Override
    public Student createStudent(StudentRequest studentRequest) {
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
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

}
