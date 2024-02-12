package com.app.entities;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
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
	private User user;
	
}
