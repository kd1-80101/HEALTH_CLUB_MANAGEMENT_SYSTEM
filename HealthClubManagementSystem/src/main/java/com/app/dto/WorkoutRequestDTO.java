package com.app.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    
}
