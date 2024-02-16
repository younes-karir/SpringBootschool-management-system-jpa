package com.example.schoolmanagementsystem.dto;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {


    @NotBlank(message = "student first name is empty")
    @Size(min = 3,message = "student first name ist short than 3 characters")
    private String studentFistName;

    @Size(min = 3,message = "student last name ist short than 3 characters")
    @NotBlank(message = "student last name is empty")
    private String studentLastName;

    @NotBlank(message = "student email is empty")
    @Email(message = "student email is not valid")
    private String studentEmail;

    @Valid
    private GuardianRequest guardian;
}
