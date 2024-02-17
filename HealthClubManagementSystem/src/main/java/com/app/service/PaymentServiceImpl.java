package com.app.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PaymentDao;
import com.app.dao.UserDao;
import com.app.dto.PaymentRequestDTO;
import com.app.dto.PaymentResponseDTO;
import com.app.entities.Payment;
import com.app.entities.User;
import com.app.enums.Membership;

@Service
@org.springframework.transaction.annotation.Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public PaymentResponseDTO processPayment(PaymentRequestDTO request) {
		User user = userDao.findByEmail(request.getEmail());
		if (user == null) {
			return new PaymentResponseDTO(request.getEmail(), null, false, "User not found");
		}

		Payment existingPayment = paymentDao.findByUserEmail(request.getEmail());
		Membership membership = request.getMembership();
		LocalDateTime expirationDate = calculateExpirationDate(existingPayment, membership);

		double paymentAmount = calculatePaymentAmount(membership, existingPayment);

		if (existingPayment != null) {
			// Update existing payment
			updateExistingPayment(existingPayment, expirationDate, paymentAmount);
		} else {
			// Create new payment
			createNewPayment(user, membership, expirationDate, paymentAmount);
		}

		return new PaymentResponseDTO(request.getEmail(), expirationDate, true, "Payment processed successfully");
	}

	private LocalDateTime calculateExpirationDate(Payment existingPayment, Membership membership) {
		LocalDateTime currentDate = LocalDateTime.now();
		if (existingPayment != null) {
			currentDate = existingPayment.getExpirationDate();
		}
		switch (membership) {
		case SILVER:
			return currentDate.plusMonths(3);
		case GOLD:
			return currentDate.plusMonths(6);
		case PLATINUM:
			return currentDate.plusYears(1);
		default:
			return currentDate;
		}
	}

	private double calculatePaymentAmount(Membership membership, Payment existingPayment) {
		double baseAmount = 0.0;
		if (existingPayment != null) {
			long remainingDuration = ChronoUnit.DAYS.between(LocalDateTime.now(), existingPayment.getExpirationDate());
			baseAmount = calculatePaymentAmount(existingPayment.getMembership()) * remainingDuration / 365.0;
		}
		return baseAmount + calculatePaymentAmount(membership);
	}

	private double calculatePaymentAmount(Membership membership) {
		switch (membership) {
		case SILVER:
			return 3000.0;
		case GOLD:
			return 5500.0;
		case PLATINUM:
			return 10000.0;
		default:
			return 0.0;
		}
	}

	private void updateExistingPayment(Payment existingPayment, LocalDateTime expirationDate, double paymentAmount) {
		existingPayment.setPaymentStatus(true);
		existingPayment.setPaymentDate(LocalDateTime.now());
		existingPayment.setExpirationDate(expirationDate);
		existingPayment.setTotalPayment(paymentAmount);
		paymentDao.save(existingPayment); // No need to create a new row, just update the existing one
	}

	private void createNewPayment(User user, Membership membership, LocalDateTime expirationDate,
			double paymentAmount) {
		Payment newPayment = new Payment();
		newPayment.setTransactionNo(generateTransactionNumber());
		newPayment.setPaymentStatus(true);
		newPayment.setPaymentDate(LocalDateTime.now());
		newPayment.setMembership(membership);
		newPayment.setTotalPayment(paymentAmount);
		newPayment.setUser(user);
		newPayment.setExpirationDate(expirationDate);
		paymentDao.save(newPayment);
	}

	private String generateTransactionNumber() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(50, random).toString(32);
	}
}
