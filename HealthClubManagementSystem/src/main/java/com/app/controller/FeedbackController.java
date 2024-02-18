package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FeedbackRequestDTO;
import com.app.dto.FeedbackResponseDTO;
import com.app.service.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/given")
    public ResponseEntity<FeedbackResponseDTO> givenFeedback(@Validated @RequestBody FeedbackRequestDTO feedbackRequestDTO) {
        return new ResponseEntity<>(feedbackService.giveFeedbackToTrainer(feedbackRequestDTO), HttpStatus.CREATED);
    }
}
