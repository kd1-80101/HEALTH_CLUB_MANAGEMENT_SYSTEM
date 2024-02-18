package com.app.service;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FeedBackDao;
import com.app.dao.UserDao;
import com.app.dto.FeedbackRequestDTO;
import com.app.dto.FeedbackResponseDTO;
import com.app.entities.Feedback;
import com.app.entities.User;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private FeedBackDao feedbackDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Feedback> feedbackList(@Valid Long id) {
		return feedbackDao.findAllByTrainerId(id);

	}

	
	@Override
	public FeedbackResponseDTO giveFeedbackToTrainer(FeedbackRequestDTO feedbackRequestDTO) {
	    User customer = userDao.findById(feedbackRequestDTO.getCustomerId()).orElseThrow();
	    User trainer = userDao.findById(feedbackRequestDTO.getTrainerId()).orElseThrow();
	    
	    // Create a new Feedback instance
	    Feedback feedback = new Feedback();
	    feedback.setRating(feedbackRequestDTO.getRating());
	    feedback.setFeedbackText(feedbackRequestDTO.getFeedbackText());
	    feedback.setFeedbackDate(feedbackRequestDTO.getFeedbackDate());
	    feedback.setCustomer(customer);
	    feedback.setTrainer(trainer);
	    
	    // Save the feedback
	    Feedback savedFeedback = feedbackDao.save(feedback);

	    // Map the saved feedback to DTO
	    FeedbackResponseDTO responseDTO = mapper.map(savedFeedback, FeedbackResponseDTO.class);
	    responseDTO.setCustomerId(customer.getId());
	    responseDTO.setTrainerId(trainer.getId());

	    return responseDTO;
	}

}
