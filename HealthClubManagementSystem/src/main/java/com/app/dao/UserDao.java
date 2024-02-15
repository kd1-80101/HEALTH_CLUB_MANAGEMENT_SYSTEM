package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;
import com.app.enums.Role;
import com.app.enums.Status;

public interface UserDao extends JpaRepository<User, Long> {

//	Optional<User> findByEmail(String email);
	User findByEmail(String email);

	List<User> findAllByRole(Role role);

	List<User> findAllByStatus(Status status);

	 List<User> findAllByStatusAndRole(Status status, Role role);
}