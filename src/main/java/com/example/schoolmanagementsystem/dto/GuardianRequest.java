package com.example.schoolmanagementsystem.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GuardianRequest {


    @NotBlank(message = "guardian name is empty")
    @Size(min = 3,message = "guardian name ist short than 3 characters")
    private String name;

    @NotBlank(message = "guardian email is empty")
    @Email(message = "guardian email is not valid")
    private String email;

    @NotEmpty(message = "guardian phone number is empty")
    private String phoneNumber;
}
