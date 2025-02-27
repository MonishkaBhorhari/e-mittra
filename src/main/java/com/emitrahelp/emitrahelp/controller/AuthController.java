package com.emitrahelp.emitrahelp.controller;


import com.emitrahelp.emitrahelp.dto.OtpRequestDTO;
import com.emitrahelp.emitrahelp.dto.SignupRequestDTO;
import com.emitrahelp.emitrahelp.services.authentication.AuthService;

import com.emitrahelp.emitrahelp.services.authentication.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5500")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private OTPService otpService;

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestBody OtpRequestDTO request) {
        boolean sent = otpService.sendOtp(request.getEmail(), request.getPhone());
        if (sent) {
            return ResponseEntity.ok("OTP sent successfully!");
        } else {
            return ResponseEntity.badRequest().body("Failed to send OTP");
        }
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody OtpRequestDTO request) {
        boolean verified = otpService.verifyOtp(request.getEmail(), request.getOtp());
        if (verified) {
            return ResponseEntity.ok("OTP verified successfully!");
        } else {
            return ResponseEntity.badRequest().body("Invalid OTP");
        }
    }

    @PostMapping("/provider/sign-up")
    public ResponseEntity<?> signupProvider(@RequestBody SignupRequestDTO signupRequestDTO) {
        if (!otpService.isOtpVerified(signupRequestDTO.getEmail())) {
            return ResponseEntity.badRequest().body("OTP not verified!");
        }
        return ResponseEntity.ok(authService.signupProvider(signupRequestDTO));
    }
}
