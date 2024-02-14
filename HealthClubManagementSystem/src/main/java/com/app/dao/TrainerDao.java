package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Trainer;

public interface TrainerDao extends JpaRepository<Trainer, Long> {

	
}
