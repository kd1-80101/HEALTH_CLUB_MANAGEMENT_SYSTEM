package com.app.service;

import java.util.List;

import com.app.dto.RegisterUserDTO;
import com.app.dto.approvedDTO;
import com.app.entities.User;
import com.app.enums.Role;
import com.app.enums.Status;

public interface UserService {

public RegisterUserDTO registerUser(RegisterUserDTO details);

public List<User> pendingUsersList();

public  Status getStatus(String email);

public  Role getRole(String email);

public approvedDTO approvedUsers(approvedDTO approved);

public List<User> customerList();

public List<User> trainerList();

}
		

	

