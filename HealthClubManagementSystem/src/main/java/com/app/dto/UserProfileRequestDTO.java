package com.app.dto;

import com.app.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class UserProfileRequestDTO {
	@NotBlank(message = "First name is required")
	@Size(max = 50, message = "First name must be less than or equal to 50 characters")
	private String firstName;

	@NotBlank(message = "Last name is required")
	@Size(max = 50, message = "Last name must be less than or equal to 50 characters")
	private String lastName;

	@NotNull(message = "Date of birth is required")
	@Past(message = "Date of birth must be in the past")
	private LocalDate dateOfBirth;

	@NotNull(message = "Gender is required")
	private Gender gender;

	private double height;

	private double weight;

	@Email(message = "Email must be valid")
	private String email;
}
