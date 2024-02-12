package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="workout_chart")
public class WorkoutChart extends BaseEntity {
	
	@Column(name="workout_details", length = 250, nullable = false)
	private String workoutDetails;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
}
