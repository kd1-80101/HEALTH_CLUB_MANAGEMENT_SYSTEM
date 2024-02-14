package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.FeedbackService;
import com.app.service.UserService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/myfeedbacks/{id}")
	public ResponseEntity<?> getFeedbackList(@PathVariable @Valid Long id ){
	
		return ResponseEntity.status(HttpStatus.OK).body(feedbackService.feedbackList(id));
	}
	
	
}
