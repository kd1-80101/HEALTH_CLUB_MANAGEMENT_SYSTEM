package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Payment;

public interface PaymentDao extends JpaRepository<Payment, Long> {

	Payment findByUserEmail(String email);

//	@Query("SELECT p FROM Payment p JOIN FETCH p.membership m WHERE p.customer_id = :customerId")
//	Optional<Payment> findByCustomerIdWithMembership(@Param("customerId") Long customerId);

}
