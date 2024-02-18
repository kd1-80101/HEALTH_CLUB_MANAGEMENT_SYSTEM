package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

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
    private ModelMapper modelMapper;

    @Override
    public ProgressResponseDTO addProgress(ProgressRequestDTO progressRequestDTO) {
        User customer = userDao.findById(progressRequestDTO.getCustomerId())
                                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        User trainer = userDao.findById(progressRequestDTO.getTrainerId())
                .orElseThrow(() -> new IllegalArgumentException("Trainer not found"));
        // Check if the user is a customer
        if (customer.getRole() != Role.TRAINER) {
            throw new IllegalArgumentException("Only customers can add progress");
        }

        // Mapping DTO to entity
        Progress progress = modelMapper.map(progressRequestDTO, Progress.class);
        progress.setCustomer(customer);
        progress.setTrainer(trainer); 

        // Save progress to the database
        Progress savedProgress = progressDao.save(progress);

        // Mapping entity to response DTO
        ProgressResponseDTO responseDTO = modelMapper.map(savedProgress, ProgressResponseDTO.class);
        responseDTO.setCustomerId(progressRequestDTO.getCustomerId());

        return responseDTO;
    }

    @Override
    public ProgressResponseDTO getProgressList(Long userId) {
        // Retrieve progress data from the database
        List<Progress> progressList = progressDao.findByCustomerId(userId);

        // Map progress entities to DTOs
        List<ProgressResponseDTO> progressDTOList = progressList.stream()
                .map(progress -> modelMapper.map(progress, ProgressResponseDTO.class))
                .collect(Collectors.toList());

        // Create a response DTO containing the list of progress DTOs
        ProgressResponseDTO responseDTO = new ProgressResponseDTO();
        responseDTO.setProgressList(progressDTOList);

        return responseDTO;
    }
}
