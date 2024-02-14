package com.app.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.app.entities.Feedback;
import com.app.entities.Trainer;

public interface FeedbackService {

	List<Feedback> feedbackList(@Valid Long id);

	
}
