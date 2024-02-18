package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Trainer;
import com.app.entities.User;

public interface TrainerDao extends JpaRepository<Trainer, Long> {

	Optional<Trainer> findByTrainer(User trainer);


	
}
