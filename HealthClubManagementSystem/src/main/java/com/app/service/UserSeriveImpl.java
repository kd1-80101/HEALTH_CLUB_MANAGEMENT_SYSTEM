package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.dto.RegisterUserDTO;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.entities.User;

@Service
@Transactional
public class UserSeriveImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public SigninResponse getUser(SigninRequest cred) {
		User tempUser = userDao.findByEmail(cred.getEmail()).orElseThrow();
		SigninResponse resp= new SigninResponse();
		if(tempUser.getPassword().equals(cred.getPassword())) {
			resp.setStatus(true);
		}
		return resp;
	}

	@Override
	public RegisterUserDTO registerUser(RegisterUserDTO reqDTO) {
		User user=mapper.map(reqDTO, User.class);
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		return mapper.map(userDao.save(user), RegisterUserDTO.class);
	
	}

}
