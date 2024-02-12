package com.app.service;

import com.app.dto.RegisterUserDTO;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;

public interface UserService {

public SigninResponse getUser(SigninRequest cred);

public RegisterUserDTO registerUser(RegisterUserDTO details);
		

	
}
