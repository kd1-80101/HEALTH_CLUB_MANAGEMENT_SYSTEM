package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {
    private Long id;
    private String eventName;
    private LocalDateTime eventDate;
    private String eventDescription;

    // Getters and setters
}
