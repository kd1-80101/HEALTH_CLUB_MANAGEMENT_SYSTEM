package com.app.service;

import javax.validation.Valid;

import com.app.dto.WorkoutRequestDTO;
import com.app.dto.WorkoutResponseDTO;

public interface WorkoutService {

	WorkoutResponseDTO getWorkout(Long workoutId);

	WorkoutResponseDTO saveOrUpdateWorkout(WorkoutRequestDTO requestDTO);

}
