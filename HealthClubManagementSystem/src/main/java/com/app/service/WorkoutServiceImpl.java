package com.app.service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.app.dao.UserDao;
import com.app.dao.WorkoutDao;
import com.app.dto.WorkoutRequestDTO;
import com.app.dto.WorkoutResponseDTO;
import com.app.entities.User;
import com.app.entities.Workout;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkoutServiceImpl implements WorkoutService {

	@Autowired
    private WorkoutDao workoutDAO;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private ModelMapper mapper;

    @Autowired
    public WorkoutServiceImpl(WorkoutDao workoutDAO, UserDao userDao, ModelMapper mapper) {
        this.workoutDAO = workoutDAO;
        this.mapper = mapper;
        this.userDao = userDao;
    }


//	@Override
//    public WorkoutResponseDTO getWorkout(Long workoutId) {
//        // Fetch the workout
//        Workout workout = workoutDAO.findById(workoutId)
//                .orElseThrow(() -> new EntityNotFoundException("Workout not found with id: " + workoutId));
//
//        // Mapping Entity to ResponseDTO
//        return mapper.map(workout, WorkoutResponseDTO.class);
//    }
    
    @Override
    public WorkoutResponseDTO getWorkout(Long workoutId) {
        // Fetch the workout
        Workout workout = workoutDAO.findById(workoutId)
                .orElseThrow(() -> new EntityNotFoundException("Workout not found with id: " + workoutId));

        // Custom mapping using ModelMapper
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.typeMap(Workout.class, WorkoutResponseDTO.class)
              .addMappings(mapper -> mapper.map(src -> src.getCustomer().getId(), WorkoutResponseDTO::setCustomerId));

        // Mapping Entity to ResponseDTO
        return mapper.map(workout, WorkoutResponseDTO.class);
    }


	@Override
	public WorkoutResponseDTO saveOrUpdateWorkout(@Valid WorkoutRequestDTO requestDTO) {
		// Fetch the user
        User user = userDao.findById(requestDTO.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + requestDTO.getCustomerId()));

        // Check if there is an existing workout for the user
        Workout existingWorkout = workoutDAO.findByCustomer(user);

        // If an existing workout is found, update it; otherwise, create a new one
        if (existingWorkout != null) {
            // Update existing workout
            mapper.map(requestDTO, existingWorkout);
            // Set the user (just to ensure correctness, though it should already be set)
            existingWorkout.setCustomer(user);
            // Save updated workout
            existingWorkout = workoutDAO.save(existingWorkout);
        } else {
            // Create new workout
            Workout newWorkout = mapper.map(requestDTO, Workout.class);
            // Set the user
            newWorkout.setCustomer(user);
            // Save new workout
            existingWorkout = workoutDAO.save(newWorkout);
        }

        // Mapping Entity to ResponseDTO
        WorkoutResponseDTO savedWorkout= mapper.map(existingWorkout, WorkoutResponseDTO.class);
        savedWorkout.setCustomerId(existingWorkout.getCustomer().getId());
        return savedWorkout;
	}
	
	
}
