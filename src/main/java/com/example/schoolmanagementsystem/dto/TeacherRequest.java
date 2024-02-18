package com.example.schoolmanagementsystem.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class TeacherRequest {


    @NotEmpty(message = "teacher first name is empty")
    private String firstName;

    @NotEmpty(message = "teacher first name is empty")
    private String lastName;

    @NotNull(message = "teacher email can't be empty")
    @Email(message = "enter a valid email")
    private String email;


}
