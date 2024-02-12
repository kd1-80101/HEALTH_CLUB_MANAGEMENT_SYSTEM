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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payments")
public class Payment  extends BaseEntity{

	@Column(name="transaction_no" , unique = true,nullable = false)
	private String transactionNo;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="payment_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime paymentDate;
	
	@Column(name="total_payment")
	private double totalPayment;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
}
