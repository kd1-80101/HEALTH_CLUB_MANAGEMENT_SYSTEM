package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.app.enums.Gender;
import com.app.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO {

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Past
	private LocalDate dateOfBirth;

	private Gender gender;

	private double height;
	
	private double weigth;

	private byte[] profileId;

	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	private Role role;

}
