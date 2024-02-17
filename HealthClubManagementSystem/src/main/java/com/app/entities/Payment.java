package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.enums.Membership;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {

	@Column(name = "transaction_no", unique = true, nullable = false)
	private String transactionNo;

	@Column(name = "payment_status")
	private boolean paymentStatus;

	@Column(name = "payment_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime paymentDate;

	@Enumerated(EnumType.STRING)
	private Membership membership;

	@Column(name = "total_payment")
	private double totalPayment;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "expiration_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime expirationDate; // New field for expiration date

}
