package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Payment;

public interface PaymentDao extends JpaRepository<Payment, Long> {

	Payment findByUserEmail(String email);

}
