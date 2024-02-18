package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<String> addProgress(@RequestBody ProgressRequestDTO requestDTO) {
        try {
            progressService.addProgress(requestDTO);
            return ResponseEntity.ok("Progress added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add progress: " + e.getMessage());
        }
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<ProgressResponseDTO> getProgressList(@PathVariable Long userId) {
        try {
            ProgressResponseDTO responseDTO = progressService.getProgressList(userId);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
