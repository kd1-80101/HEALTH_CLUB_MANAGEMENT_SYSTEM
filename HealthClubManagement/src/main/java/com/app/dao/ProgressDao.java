package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Progress;

public interface ProgressDao extends JpaRepository<Progress, Long> {

	List<Progress> findByCustomerId(Long id);

}
