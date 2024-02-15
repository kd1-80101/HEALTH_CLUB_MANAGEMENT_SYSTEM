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
@Table(name="feedbacks")
public class Feedback extends BaseEntity {
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="feedback_text", length = 100)
	private String feedbackText;

	@Column(name= "feedback_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime feedbackDate;
	
	@ManyToOne
	@JoinColumn(name="customer_id",nullable = false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;
	
}
