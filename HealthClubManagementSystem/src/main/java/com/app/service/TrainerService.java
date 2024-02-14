package com.app.service;

import com.app.dto.ExpertiseDTO;
import com.app.entities.Trainer;


public interface TrainerService {

	public Trainer trainerExpertice(Long id);

	public ExpertiseDTO addExpertise( ExpertiseDTO expertise);


}
