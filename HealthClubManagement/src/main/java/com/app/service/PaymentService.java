package com.app.service;

import java.util.Optional;

import javax.validation.Valid;

import com.app.dto.PaymentRequestDTO;
import com.app.dto.PaymentResponseDTO;
import com.app.entities.Payment;

public interface PaymentService {

	PaymentResponseDTO processPayment(@Valid PaymentRequestDTO request);

//	public Optional<Payment> getPaymentWithMembership(Long customerId);
}
