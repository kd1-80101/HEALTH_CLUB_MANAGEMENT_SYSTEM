package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DietRequestDTO;
import com.app.dto.DietResponseDTO;
import com.app.service.DietService;

@RestController
@RequestMapping("/diet")
public class DietController {
	@Autowired
	private DietService dietService;
	
	@PostMapping("/assign")
    public ResponseEntity<DietResponseDTO> assignDiet(@Validated @RequestBody DietRequestDTO dietRequestDTO) {
        return new ResponseEntity<>(dietService.assignDietToCustomer(dietRequestDTO), HttpStatus.CREATED);
    }

   	
}
