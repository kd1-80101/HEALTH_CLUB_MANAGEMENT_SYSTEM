package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="customers")
public class Customer extends BaseEntity {
	
	@Column(name="membership_type", length = 50, nullable = false)
	private String membership;
	
	@Column(name="membership_validity")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate membershipValidity;
	
	@Column(name="approval_status", length = 50, nullable = false)
	private String approvalStatus;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@MapsId
	private User user;
	
	
	
}
