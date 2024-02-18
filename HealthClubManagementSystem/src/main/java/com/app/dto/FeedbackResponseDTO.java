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
public class FeedbackResponseDTO {
    
    private Long id;
    
    private int rating;
    
    private String feedbackText;
    
    private LocalDateTime feedbackDate;
    
    private Long customerId;
    
    private Long trainerId;
}
