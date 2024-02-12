package com.app.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@AttributeOverride(name = "id", column = @Column(name = "diet_id"))
public class Diet extends BaseEntity {
	
	@Column(name="diet_name", length = 60, nullable = false)
	private String dietName;
	
	@Column(name="description", length = 250, nullable = false)
	private String description;
}
