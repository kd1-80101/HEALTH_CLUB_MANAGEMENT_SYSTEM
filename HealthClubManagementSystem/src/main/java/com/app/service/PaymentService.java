package com.app.service;

import javax.validation.Valid;

import com.app.dto.PaymentRequestDTO;
import com.app.dto.PaymentResponseDTO;

public interface PaymentService {

	PaymentResponseDTO processPayment(@Valid PaymentRequestDTO request);

}
