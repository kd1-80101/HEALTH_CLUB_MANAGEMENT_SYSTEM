package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.WorkoutChart;

public interface WorkoutChartDao extends JpaRepository<WorkoutChart, Long> {

}
