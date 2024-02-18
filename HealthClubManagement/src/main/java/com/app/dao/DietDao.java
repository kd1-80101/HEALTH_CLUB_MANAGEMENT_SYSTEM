package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Diet;

public interface DietDao extends JpaRepository<com.app.entities.Diet, Long> {

	Diet findByCustomerId(Long id);

}
