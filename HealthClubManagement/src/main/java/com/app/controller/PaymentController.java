package com.app.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PaymentRequestDTO;
import com.app.dto.PaymentResponseDTO;
import com.app.entities.Payment;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/process")
	public ResponseEntity<PaymentResponseDTO> processPayment(@Valid @RequestBody PaymentRequestDTO request) {
		PaymentResponseDTO response = paymentService.processPayment(request);
		return ResponseEntity.ok(response);
	}
	
//	@GetMapping("/membership/{customerId}")
//    public ResponseEntity<Payment> getPaymentWithMembership(@PathVariable Long customerId) {
//        // Call the service method to fetch payment details with membership for the specified customer
//        Optional<Payment> paymentWithMembership = paymentService.getPaymentWithMembership(customerId);
//        
//        // Check if payment details with membership are found
//        if (paymentWithMembership.isPresent()) {
//            // If found, return them with a 200 OK status
//            return ResponseEntity.ok(paymentWithMembership.get());
//        } else {
//            // If not found, return a 404 Not Found status
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
}
