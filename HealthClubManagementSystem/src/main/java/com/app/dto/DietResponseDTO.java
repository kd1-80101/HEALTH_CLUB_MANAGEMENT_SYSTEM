package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DietResponseDTO {

    private Long id;

    private String dietName;

    private String description;

    private Long trainerId;

    private Long customerId;

}
