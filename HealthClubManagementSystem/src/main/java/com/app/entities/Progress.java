package com.app.entities;

import java.time.LocalDateTime;

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
@Table(name="progress")
public class Progress extends BaseEntity {

	@Column(name="weight")
	private double weight;
	
	@Column(name="body_measurement_1")
	private double bodyMeasurement1;
	
	@Column(name="body_measurement_2")
	private double bodyMeasurement2;
	
	@Column(name= "progress_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime progressDate;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
}
