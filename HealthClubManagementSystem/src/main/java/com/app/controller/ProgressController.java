package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProgressRequestDTO;
import com.app.dto.ProgressResponseDTO;
import com.app.service.ProgressService;

@RestController
@RequestMapping("/progress")
public class ProgressController {
	@Autowired
	private ProgressService progressService;
	
	@PostMapping("/add")
    public ResponseEntity<ProgressResponseDTO> addProgress(@Validated @RequestBody ProgressRequestDTO progressRequestDTO) {
        return new ResponseEntity<>(progressService.giveProgressToCustomer(progressRequestDTO), HttpStatus.CREATED);
    }

   	
}
