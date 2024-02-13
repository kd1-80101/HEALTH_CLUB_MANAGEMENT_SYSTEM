package com.app.entities;

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
@Table(name = "OtpDetails_User")
public class OtpDetails_User extends BaseEntity {
	
	@Column(name="otp_id")
	private long otp_id;
	
	@Column(name="user_id")
	private long user_id;

}
