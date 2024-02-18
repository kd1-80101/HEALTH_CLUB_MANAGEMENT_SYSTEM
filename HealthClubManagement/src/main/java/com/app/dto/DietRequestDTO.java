package com.app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DietRequestDTO {

    @NotBlank(message = "Diet name is required")
    @Size(max = 60, message = "Diet name must be at most 60 characters long")
    private String dietName;

    @NotBlank(message = "Description is required")
    @Size(max = 250, message = "Description must be at most 250 characters long")
    private String description;

    private Long trainerId;

    private Long customerId;

}
