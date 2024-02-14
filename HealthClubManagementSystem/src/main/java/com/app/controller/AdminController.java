package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.approvedDTO;
import com.app.service.UserService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/pendingList")
	public ResponseEntity<?> pendingUsersList(){
	
		return ResponseEntity.status(HttpStatus.OK).body(userService.pendingUsersList());
	}
	
	@PostMapping("/approved")
	public ResponseEntity<?> approvedUsers(@RequestBody @Valid approvedDTO approved){
	
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.approvedUsers(approved));
	}

}
