package com.app.entities;

import javax.persistence.AttributeOverride;
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
@Table(name="trainers")
@AttributeOverride(name = "id", column = @Column(name = "trainer_id"))
public class Trainer extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
