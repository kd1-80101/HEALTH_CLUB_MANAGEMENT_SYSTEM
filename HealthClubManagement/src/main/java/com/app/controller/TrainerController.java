package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ExpertiseDTO;
import com.app.service.FeedbackService;
import com.app.service.TrainerService;
import com.app.service.UserService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private TrainerService trainerService;
	
	@GetMapping("/myfeedbacks/{id}")
	public ResponseEntity<?> getFeedbackList(@PathVariable @Valid Long id ){
	
		return ResponseEntity.status(HttpStatus.OK).body(feedbackService.feedbackList(id));
	}
	
	
	@PostMapping("/editExpertise")
	public ResponseEntity<?> addExpertise(@RequestBody @Valid ExpertiseDTO expertise){
	
		return ResponseEntity.status(HttpStatus.OK).body(trainerService.addExpertise(expertise));
	}
	
}
