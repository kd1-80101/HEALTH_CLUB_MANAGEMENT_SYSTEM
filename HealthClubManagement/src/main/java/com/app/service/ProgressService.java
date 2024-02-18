package com.app.service;

import com.app.dto.ProgressRequestDTO;
import com.app.dto.ProgressResponseDTO;

public interface ProgressService {

//	FeedbackResponseDTO giveProgressToCustomer(FeedbackRequestDTO feedbackRequestDTO);
//	public ProgressResponseDTO giveProgressToCustomer(ProgressRequestDTO progressRequestDTO);
    ProgressResponseDTO addProgress(ProgressRequestDTO progressRequestDTO);
    ProgressResponseDTO getProgressList(Long userId);


//	List<Progress> progressList(@Valid Long id);

}
