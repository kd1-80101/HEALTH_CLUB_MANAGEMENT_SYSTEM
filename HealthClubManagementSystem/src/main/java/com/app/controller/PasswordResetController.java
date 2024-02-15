package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.ResetPasswordRequest;
import com.app.service.MyLogger;
import com.app.service.OtpService;
import com.app.service.UserService;

@RestController
@RequestMapping("/api")
public class PasswordResetController {

	private MyLogger logger = MyLogger.getInstance();
	
	@Autowired
	private OtpService otpService;
    @Autowired
    private UserService userService;

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        String email = request.getEmail();
        String otp = request.getOtp();
        String newPassword = request.getNewPassword();// Verify OTP

        if (!otpService.verifyOTP(email, otp)) {
            logger.info("something is wrong the password is not resetting");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
        }

        // Reset password
        userService.resetPassword(email, newPassword);

        return ResponseEntity.ok("Password reset successfully");
    }
}

