package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DietDao;
import com.app.dao.UserDao;
import com.app.dto.DietRequestDTO;
import com.app.dto.DietResponseDTO;
import com.app.entities.Diet;
import com.app.entities.User;
import com.app.enums.Role;

@Service
@Transactional
public class DietServiceImpl implements DietService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DietDao dietDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public DietResponseDTO assignDietToCustomer(DietRequestDTO dietRequestDTO) {
		User customer = userDao.findById(dietRequestDTO.getCustomerId()).orElseThrow();
		User trainer = userDao.findById(dietRequestDTO.getTrainerId()).orElseThrow();
		if (customer.getRole() == Role.CUSTOMER) {
			Diet diet = dietDao.findByCustomerId(customer.getId());
			if (diet == null) {
				Diet transientDiet = mapper.map(dietRequestDTO, Diet.class);
				transientDiet.setCustomer(customer);
				transientDiet.setTrainer(trainer);
				dietDao.save(transientDiet);
				DietResponseDTO responseDTO = mapper.map(transientDiet, DietResponseDTO.class);
				responseDTO.setCustomerId(customer.getId());
				responseDTO.setTrainerId(trainer.getId());
				return responseDTO;
			} else {
				diet.setDietName(dietRequestDTO.getDietName());
				diet.setDescription(dietRequestDTO.getDescription());
				diet.setCustomer(customer);
				diet.setTrainer(trainer);
				dietDao.save(diet);

				DietResponseDTO responseDTO = mapper.map(diet, DietResponseDTO.class);
				responseDTO.setCustomerId(customer.getId());
				responseDTO.setTrainerId(trainer.getId());

				return responseDTO;
			}
		}
		else
			return new DietResponseDTO(null,null,null,null, null);
	}

}
