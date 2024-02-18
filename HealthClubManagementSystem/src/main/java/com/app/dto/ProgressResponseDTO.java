package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgressResponseDTO {

    private Long id;
    private Long customerId;
    private Long trainerId;
    private double weight;
    private double bodyMeasurement1;
    private double bodyMeasurement2;
    private LocalDateTime progressDate;

    // Constructors, getters, and setters
}
