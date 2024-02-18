package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutResponseDTO {
    private Long id;
    private Long customerId;
    private String workoutDetails;
    private String goal;
    private int exerciseDurationMinutes;
    private String exerciseIntensity;
}
