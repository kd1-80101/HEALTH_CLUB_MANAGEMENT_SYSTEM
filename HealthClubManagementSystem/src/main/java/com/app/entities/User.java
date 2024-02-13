package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.Gender;
import com.app.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity // Entity representing user information
@Table(name = "users")
public class User extends BaseEntity {

	@Column(name = "first_name", length = 50, nullable = false) // Column for storing first name and it cannot be null
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false) // Column for storing last name and it cannot be null
	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth; // Field for storing the date of birth of the user

	@Enumerated(EnumType.STRING) // Specifies that the 'gender' field is mapped to a string value in the database
	private Gender gender;

	private double height;

	private double weight;

	@Lob
	private byte[] profileId; // Field for storing the profile picture of the user as a byte array

	@Column(length = 100, unique = true) // Column for storing unique email address
	private String email;

	@Column(nullable = false) // Column for storing the password, and it cannot be null
	private String password;

	@Enumerated(EnumType.STRING) // Specifies that the 'role' field is mapped to a string value in the database
	private Role role; // Enum representing the role of the user (e.g. admin, user, customer)

}
