package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Customer;

@Service
public interface CustomerService {

//    public Customer getCustomerWithPaymentsByUserId(Long userId);
	 public List<Customer> getAllCustomersWithPayments();
}

