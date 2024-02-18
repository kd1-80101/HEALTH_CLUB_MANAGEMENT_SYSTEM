package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name="workouts")
public class Workout extends BaseEntity {
	
	@OneToOne
	@JoinColumn(name = "customer_Id")
	private User customer;
	
	@Column(name="workout_details", length = 500, nullable = false)
	private String workoutDetails;

	@Column
    private String goal;
	
    @Column(name= "exercise_duration_minutes")
    private int exerciseDurationMinutes; // Added field for exercise data
    
    @Column(name= "exercise_intensity")
    private String exerciseIntensity;

}
