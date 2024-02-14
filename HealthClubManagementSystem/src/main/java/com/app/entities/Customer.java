package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.Membership;

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
	
	@Enumerated(EnumType.STRING)
	private Membership membership;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate membershipEnd;
	
	@OneToOne
    @JoinColumn(name="user_id")
    @MapsId
    private User user;
	
	@Column
	private boolean payment;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate membershipStart;
	
}
