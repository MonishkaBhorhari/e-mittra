package com.emitrahelp.emitrahelp.services.authentication;


import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Random;

@Service
public class OTPService {

    private final HashMap<String, String> otpStore = new HashMap<>();

    public boolean sendOtp(String email, String phone) {
        String otp = generateOtp();
        otpStore.put(email, otp);
        otpStore.put(phone, otp);

        // Send email (Use JavaMailSender)
        System.out.println("OTP for " + email + ": " + otp);

        // Send SMS (Use Twilio or other SMS provider)
        System.out.println("OTP for " + phone + ": " + otp);
        return true;
    }

    public boolean verifyOtp(String email, String otp) {
        return otp.equals(otpStore.get(email));
    }

    public boolean isOtpVerified(String email) {
        return otpStore.containsKey(email);
    }

    private String generateOtp() {
        return String.valueOf(new Random().nextInt(900000) + 100000); // 6-digit OTP
    }
}
