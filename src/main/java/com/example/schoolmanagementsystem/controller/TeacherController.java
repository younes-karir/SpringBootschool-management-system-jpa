package com.example.schoolmanagementsystem.controller;


import com.example.schoolmanagementsystem.dto.TeacherRequest;
import com.example.schoolmanagementsystem.repository.TeacherRepository;
import com.example.schoolmanagementsystem.response.ResponseHandler;
import com.example.schoolmanagementsystem.service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {


    TeacherService teacherService;



    @PostMapping
    public ResponseEntity<Object> createTeacher(@RequestBody  @Valid  TeacherRequest teacherRequest){
        return ResponseHandler.responseBuilder(
                "teacher created",
                HttpStatus.OK,
                teacherService.createTeacher(teacherRequest)
        );
    }


    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.responseBuilder(
                "teachers list",
                HttpStatus.OK,
                teacherService.getAll()
        );
    }


    @GetMapping("{id}")
    public ResponseEntity<Object> getTeacher(@PathVariable Long id){
        return ResponseHandler.responseBuilder(
                "teacher details",
                HttpStatus.OK,
                teacherService.getTeacher(id)
        );
    }

}
