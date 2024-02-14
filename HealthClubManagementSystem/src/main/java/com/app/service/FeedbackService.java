package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.entities.Feedback;

public interface FeedbackService {

	List<Feedback> feedbackList(@Valid Long id);

}
