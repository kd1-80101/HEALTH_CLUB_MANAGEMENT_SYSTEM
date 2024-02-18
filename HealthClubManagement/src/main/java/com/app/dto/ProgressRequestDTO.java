package com.app.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgressRequestDTO {

    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;

    @NotNull(message = "Trainer ID cannot be null")
    private Long trainerId;

    @Min(value = 0, message = "Weight must be greater than or equal to zero")
    private double weight;

    @Min(value = 0, message = "Body measurement 1 must be greater than or equal to zero")
    private double bodyMeasurement1;

    @Min(value = 0, message = "Body measurement 2 must be greater than or equal to zero")
    private double bodyMeasurement2;

    @NotNull(message = "Progress date cannot be null")
    private LocalDateTime progressDate;

    // Constructors, getters, and setters
}
