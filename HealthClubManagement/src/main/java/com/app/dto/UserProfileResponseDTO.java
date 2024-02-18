package com.app.dto;

import java.time.LocalDate;

import com.app.enums.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileResponseDTO {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private double height;
    private double weight;
    private String email;
}
