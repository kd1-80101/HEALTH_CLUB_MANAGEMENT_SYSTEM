package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@Table(name="diet")
public class Diet extends BaseEntity {
	
	@Column(name="diet_name", length = 60, nullable = false)
	private String dietName;
	
	@Column(name="description", length = 500, nullable = false)
	private String description;
	
	@ManyToOne
	private User trainer;
	
	@OneToOne
	private User customer;

	
}
