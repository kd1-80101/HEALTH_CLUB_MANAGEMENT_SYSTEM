package com.app.service;

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

//	@Override
//	public ExpertiseDTO addExpertise(@Valid ExpertiseDTO expertise) {
//	if(userDao.existsById(expertise.getTrainer())) {
//	Trainer save = trainerDao.save(mapper.map(expertise, Trainer.class));
//	if(save!=null)
//		expertise.setStatus(true);
//	}
//	return expertise;
//	}

	@Override
	public ExpertiseDTO addExpertise(@Valid ExpertiseDTO expertise) {
	    if(expertise.getTrainer() != null && userDao.existsById(expertise.getTrainer())) {
	        Trainer trainer = mapper.map(expertise, Trainer.class);
	        Trainer savedTrainer = trainerDao.save(trainer);
	        if(savedTrainer != null) {
	            expertise.setStatus(true);
	        }
	    }
	    return expertise;
	}

	
}
