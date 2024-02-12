package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SigninResponse {
	private String jwt;
	private String mesg;
	private boolean status;
	public SigninResponse() {
this.status=false;
	}

}
