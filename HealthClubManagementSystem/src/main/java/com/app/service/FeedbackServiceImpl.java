package com.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FeedBackDao;
import com.app.entities.Feedback;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedBackDao feedbackDao;

	@Override
	public List<Feedback> feedbackList(@Valid Long id) {
		return feedbackDao.findAllByTrainerId(id);

	}
}
