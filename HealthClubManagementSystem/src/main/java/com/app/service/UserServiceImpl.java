package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.dto.ApprovedDTO;
import com.app.dto.RegisterUserDTO;
import com.app.dto.UserProfileRequestDTO;
import com.app.dto.UserProfileResponseDTO;
import com.app.entities.User;
import com.app.enums.Role;
import com.app.enums.Status;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private ModelMapper mapper;

	@Override
	public RegisterUserDTO registerUser(RegisterUserDTO reqDTO) {
		User user = mapper.map(reqDTO, User.class);
		user.setStatus(Status.PENDING);
		user.setRole(Role.PENDING);
		user.setPassword(encoder.encode(user.getPassword()));// pwd : encrypted using SHA
		return mapper.map(userDao.save(user), RegisterUserDTO.class);

	}

	@Override
	public List<User> pendingUsersList() {

		return userDao.findAllByStatus(Status.PENDING);
	}

	@Override
	public Status getStatus(String email) {
		User temp = userDao.findByEmail(email).orElseThrow(); // TODO Auto-generated method stub
		return temp.getStatus();
	}

	@Override
	public Role getRole(String email) {
		User temp = userDao.findByEmail(email).orElseThrow(); // TODO Auto-generated method stub
		return temp.getRole();
	}

	@Override
	public ApprovedDTO approvedUsers(ApprovedDTO approved) {
		User id = userDao.findById(approved.getId()).orElseThrow();
		id.setRole(approved.getRole());
		id.setStatus(approved.getStatus());
		return new ApprovedDTO(id.getId(), id.getStatus(), id.getRole());
	}

	@Override
	public List<User> customerList() {
		return userDao.findAllByStatusAndRole(Status.APPROVED, Role.CUSTOMER);
	}

	@Override
	public List<User> trainerList() {
		return userDao.findAllByStatusAndRole(Status.APPROVED, Role.TRAINER);
	}

	@Override
	public UserProfileResponseDTO updateUserProfile(String email,@Valid UserProfileRequestDTO profileRequest) {
		Optional<User> optionalUser = userDao.findByEmail(email);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			mapper.map(profileRequest, user);
			User updatedUser = userDao.saveAndFlush(user);
			return mapper.map(updatedUser, UserProfileResponseDTO.class);
		}
		return null;
	}

}
