package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

//	@EntityGraph(attributePaths = "payment") // Eagerly fetch the payment details
//    Customer findByUserId(Long userId);
	
	@Query("SELECT c FROM Customer c LEFT JOIN FETCH c.payments")
    List<Customer> findAllWithPayments();
}
