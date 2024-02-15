package com.app.service;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TrainerDao;
import com.app.dao.UserDao;
import com.app.dto.ExpertiseDTO;
import com.app.entities.Trainer;
import com.app.entities.User;
import com.app.enums.Role;

@Service
@Transactional
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerDao trainerDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Trainer trainerExpertice(@NotNull Long id) {
		return trainerDao.findById(id).orElseThrow();
	}

	@Override
	public ExpertiseDTO addExpertise(@Valid ExpertiseDTO expertise) {
		if (expertise.getTrainer() != null && userDao.existsById(expertise.getTrainer())) {
			User trainer = userDao.findById(expertise.getTrainer()).orElseThrow();
			if(trainer.getRole()==Role.TRAINER) {
			Trainer newTrainer = new Trainer(trainer, expertise.getExpertise());
			Optional<Trainer> existingTrainerOptional = trainerDao.findByTrainer(trainer);

			if (existingTrainerOptional.isPresent()) {
				Trainer existingTrainer = existingTrainerOptional.get();
				existingTrainer.setExpertise(expertise.getExpertise());
				Trainer updatedTrainer = trainerDao.save(existingTrainer);
				if (updatedTrainer != null) {
					expertise.setStatus(true);
				}
			} else {

				Trainer savedTrainer = trainerDao.save(newTrainer);
				if (savedTrainer != null) {
					expertise.setStatus(true);
				}
			}
		}
		}
		return expertise;
	}

}
