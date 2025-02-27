package com.emitrahelp.emitrahelp.dto;


public class OtpRequestDTO {
    private String email;
    private String phone;
    private String otp;

    // Constructors
    public OtpRequestDTO() {}

    public OtpRequestDTO(String email, String phone, String otp) {
        this.email = email;
        this.phone = phone;
        this.otp = otp;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "OtpRequestDTO{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
