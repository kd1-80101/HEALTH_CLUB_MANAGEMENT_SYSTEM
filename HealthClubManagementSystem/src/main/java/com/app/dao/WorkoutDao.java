package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;
import com.app.entities.Workout;

public interface WorkoutDao extends JpaRepository<Workout, Long> {

	Workout findByCustomer(User user);

}
