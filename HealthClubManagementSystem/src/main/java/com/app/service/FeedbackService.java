package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.FeedbackRequestDTO;
import com.app.dto.FeedbackResponseDTO;
import com.app.entities.Feedback;

public interface FeedbackService {

	List<Feedback> feedbackList(@Valid Long id);

	FeedbackResponseDTO giveFeedbackToTrainer(FeedbackRequestDTO feedbackRequestDTO);

}
