package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Progress;

public interface ProgressDao extends JpaRepository<Progress, Long> {

	Progress findByCustomerId(Long id);

}
