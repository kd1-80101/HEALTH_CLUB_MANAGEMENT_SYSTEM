package com.app.controller;

import javax.validation.Valid;

import com.app.dto.WorkoutRequestDTO;
import com.app.dto.WorkoutResponseDTO;
import com.app.service.WorkoutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

	@Autowired
    private WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }
    
    
    @PostMapping("/add")
    public ResponseEntity<WorkoutResponseDTO> addOrUpdateWorkout(@Valid @RequestBody WorkoutRequestDTO requestDTO) {
        WorkoutResponseDTO responseDTO = workoutService.saveOrUpdateWorkout(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/{workoutId}")
    public ResponseEntity<WorkoutResponseDTO> getWorkout(@PathVariable Long workoutId) {
        WorkoutResponseDTO responseDTO = workoutService.getWorkout(workoutId);
        return ResponseEntity.ok(responseDTO);
    }
    
}
