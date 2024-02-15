package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordService {

    @Autowired
    private EmailService emailService;

    // Other methods...

    public void sendPasswordResetEmail(String userEmail, String otp) {
        // Additional logic...

        // Send OTP email
        emailService.sendOTPEmail(userEmail, otp);
    }
}

