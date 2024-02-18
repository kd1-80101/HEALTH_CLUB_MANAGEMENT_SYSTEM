package com.app.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackRequestDTO {
    
    @NotNull
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must not be greater than 5")
    private int rating;
    
    @NotNull
    @Size(max = 100, message = "Feedback text must be at most 100 characters")
    private String feedbackText;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime feedbackDate;
    
    @NotNull(message = "Customer ID must be provided")
    private Long customerId;
    
    @NotNull(message = "Trainer ID must be provided")
    private Long trainerId;
    
}
