package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Feedback;

public interface FeedBackDao extends JpaRepository<Feedback, Long> {

	List<Feedback> findAllByTrainerId(Long id);

	Feedback findByCustomerId(Long id);


}
