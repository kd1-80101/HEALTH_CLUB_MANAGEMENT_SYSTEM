package com.app.dto;

import javax.validation.constraints.NotNull;

import com.app.enums.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApprovedDTO {
	@NotNull
	private Long id;
	private Status status;
	private Role role;
}
