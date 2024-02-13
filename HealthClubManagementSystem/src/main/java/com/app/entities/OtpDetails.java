package com.app.entities;

import java.time.LocalDateTime;

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
@Table(name = "Otp_details")
public class OtpDetails extends BaseEntity {
	
	@Column(name="otp")
	private long otp;
	
	@Column(name="generated_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime generatedOn;
	
	@Column(name="expiry_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime expiryDate;
	
	@Column(name="is_verified")
	private boolean isVerified;

}
