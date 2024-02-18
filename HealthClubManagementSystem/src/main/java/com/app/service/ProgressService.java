package com.app.service;

import com.app.dto.ProgressRequestDTO;
import com.app.dto.ProgressResponseDTO;

public interface ProgressService {

//	FeedbackResponseDTO giveProgressToCustomer(FeedbackRequestDTO feedbackRequestDTO);

	ProgressResponseDTO giveProgressToCustomer(ProgressRequestDTO progressRequestDTO);

//	List<Progress> progressList(@Valid Long id);

}
