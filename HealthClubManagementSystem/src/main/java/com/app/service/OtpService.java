package com.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpService {
	
    private Map<String, String> otpStorage = new HashMap<>(); // In-memory storage for OTPs

    @Autowired
    private EmailService emailService; // Inject the EmailService

    public String generateAndSendOTP(String email) {
        String otp = generateOTP();
        sendOTPEmail(email, otp);
        return otp;
    }

    private String generateOTP() {
        return String.valueOf((int) ((Math.random() * 900000) + 100000));
    }

    public void sendOTPEmail(String email, String otp) {
        emailService.sendOTPEmail(email, otp);
    }

    public void saveOTP(String email, String otp) {
        otpStorage.put(email, otp);
    }
}

