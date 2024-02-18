package com.app.service;

import com.app.dto.DietRequestDTO;
import com.app.dto.DietResponseDTO;

public interface DietService {
	
	DietResponseDTO assignDietToCustomer(DietRequestDTO dietRequestDTO);

}
