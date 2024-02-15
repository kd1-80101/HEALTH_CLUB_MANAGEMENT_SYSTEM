package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserProfileRequestDTO;
import com.app.dto.UserProfileResponseDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping("/edit/{email}")
	public ResponseEntity<?> updateUserProfile(@PathVariable String email,@Valid @RequestBody UserProfileRequestDTO profileRequest,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
		}

		UserProfileResponseDTO updatedUserProfile = userService.updateUserProfile(email,profileRequest);
		if (updatedUserProfile != null) {
			return ResponseEntity.ok(updatedUserProfile);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
