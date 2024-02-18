package com.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutRequestDTO {
    
    @NotNull
    private Long customerId;

    @NotBlank
    @Size(max = 500)
    private String workoutDetails;

    @NotBlank
    private String goal;

    @Positive
    private int exerciseDurationMinutes;

    @NotBlank
    private String exerciseIntensity;
    
    public Long getCustomerId() {
        return customerId;
    }
}
