package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProgressDao;
import com.app.dao.UserDao;
import com.app.dto.ProgressRequestDTO;
import com.app.dto.ProgressResponseDTO;
import com.app.entities.Progress;
import com.app.entities.User;
import com.app.enums.Role;

@Service
@Transactional
public class ProgressServiceImpl implements ProgressService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private ProgressDao progressDao;
	
	@Autowired
	private ModelMapper mapper;

//	@Override
//	public List<Progress> progressList(@Valid Long id) {
//		return feedbackDao.findAllByTrainerId(id);
//
//	}

	
	@Override
	public ProgressResponseDTO giveProgressToCustomer(ProgressRequestDTO progressRequestDTO) {
		User customer = userDao.findById(progressRequestDTO.getCustomerId()).orElseThrow();
		User trainer = userDao.findById(progressRequestDTO.getTrainerId()).orElseThrow();
		if (customer.getRole() == Role.CUSTOMER) {
			Progress progress = progressDao.findByCustomerId(customer.getId());
			if (progress == null) {
				Progress transientProgress = mapper.map(progressRequestDTO, Progress.class);
				transientProgress.setCustomer(customer);
				transientProgress.setTrainer(trainer);
				progressDao.save(transientProgress);
				ProgressResponseDTO responseDTO = mapper.map(transientProgress, ProgressResponseDTO.class);
				responseDTO.setCustomerId(customer.getId());
				responseDTO.setTrainerId(trainer.getId());
				return responseDTO;
			} else {
				progress.setWeight(progressRequestDTO.getWeight());
				progress.setBodyMeasurement1(progressRequestDTO.getBodyMeasurement1());
				progress.setBodyMeasurement2(progressRequestDTO.getBodyMeasurement2());
				progress.setProgressDate(progressRequestDTO.getProgressDate());
				progress.setCustomer(customer);
				progress.setTrainer(trainer);
				progressDao.save(progress);

				ProgressResponseDTO responseDTO = mapper.map(progress, ProgressResponseDTO.class);
				responseDTO.setCustomerId(customer.getId());
				responseDTO.setTrainerId(trainer.getId());

				return responseDTO;
			}
		}
		else
			return new ProgressResponseDTO(null, null, null, 0, 0, 0, null);
	}

}
