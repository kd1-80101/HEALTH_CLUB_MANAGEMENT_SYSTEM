package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.CustomerDao;
import com.app.entities.Customer;

public class CustomerServiceImpl implements CustomerService {

	 @Autowired
	    private CustomerDao customerRepository;

	 public List<Customer> getAllCustomersWithPayments() {
	        // Fetch customers along with their payments using a custom query
	        return customerRepository.findAllWithPayments();
	    }

//	    public Customer getCustomerWithPaymentsByUserId(Long userId) {
//	        Optional<Customer> customerOptional = Optional.of(customerRepository.findByUserId(userId));
//	        if (customerOptional.isPresent()) {
//	            Customer customer = customerOptional.get();
//	            // Fetch payments explicitly to eagerly load them
//	            customer.getPayments().size(); // This triggers the fetching of payments
//	            return customer;
//	        }
//	        return null;
//	    }
}
