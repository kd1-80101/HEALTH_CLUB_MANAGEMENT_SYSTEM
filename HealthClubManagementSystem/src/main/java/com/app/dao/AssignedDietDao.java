package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AssignedDiet;

public interface AssignedDietDao extends JpaRepository<AssignedDiet, Long> {

}
