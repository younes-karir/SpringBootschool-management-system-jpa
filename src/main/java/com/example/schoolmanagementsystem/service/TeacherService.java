package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.TeacherRequest;
import com.example.schoolmanagementsystem.model.Teacher;

import java.util.*;

public interface TeacherService {

    Teacher createTeacher(TeacherRequest teacherRequest);
    List<Teacher> getAll();
    Teacher getTeacher(Long id);
    Teacher updateTeacher(Long id,TeacherRequest teacherRequest);
    Teacher remove(Long id);
}
