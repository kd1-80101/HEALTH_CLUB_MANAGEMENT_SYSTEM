package com.app.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApprovedDTO;
import com.app.service.FeedbackService;
import com.app.service.TrainerService;
import com.app.service.UserService;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private TrainerService trainerService;
	
	
	@GetMapping("/pendingList")
	public ResponseEntity<?> pendingUsersList(){
	
		return ResponseEntity.status(HttpStatus.OK).body(userService.getPendingUsersList());
	}
	
	@PostMapping("/approve")
	public ResponseEntity<?> approvedUsers(@RequestBody @Valid ApprovedDTO approved){
	
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.approveUsers(approved));
	}

	@GetMapping("/customerList")
	public ResponseEntity<?> customerList(){
	
		return ResponseEntity.status(HttpStatus.OK).body(userService.getCustomerList());
	}
	
	@GetMapping("/trainerList")
	public ResponseEntity<?> trainerList(){
	
		return ResponseEntity.status(HttpStatus.OK).body(userService.getTrainerList());
	}
	
	@GetMapping("/trainerExpertice/{id}")
	public ResponseEntity<?> trainerExpertice(@PathVariable @NotNull Long id){
	
		return ResponseEntity.status(HttpStatus.OK).body(trainerService.trainerExpertice(id));
	}

}
