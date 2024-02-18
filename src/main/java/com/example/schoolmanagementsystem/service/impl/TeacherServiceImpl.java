package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.advice.exceptions.ElementNotFoundException;
import com.example.schoolmanagementsystem.advice.exceptions.ExistedElementException;
import com.example.schoolmanagementsystem.dto.TeacherRequest;
import com.example.schoolmanagementsystem.model.Teacher;
import com.example.schoolmanagementsystem.repository.TeacherRepository;
import com.example.schoolmanagementsystem.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    TeacherRepository  teacherRepository;

    @Override
    public Teacher createTeacher(TeacherRequest teacherRequest) {
        if(teacherRepository.findTeacherByEmail(teacherRequest.getEmail()) !=null)
            throw new ExistedElementException("teacher email already used");
        Teacher teacher = Teacher.builder()
                .firstName(teacherRequest.getFirstName())
                .lastName(teacherRequest.getLastName())
                .email(teacherRequest.getEmail())
                .build();
        return teacherRepository.save(teacher);
    }



    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }


    public Teacher getTeacher(Long id){
        if(teacherRepository.findById(id).isEmpty())
            throw new ElementNotFoundException("teacher not found");
        return teacherRepository.findById(id).get();
    }
}
