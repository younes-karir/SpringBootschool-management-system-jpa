package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.TeacherRequest;
import com.example.schoolmanagementsystem.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher createTeacher(TeacherRequest teacherRequest);
    List<Teacher> getAll();
    Teacher getTeacher(Long id);
}
