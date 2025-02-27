
package com.emitrahelp.emitrahelp.dto;



public class SignupRequestDTO {
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private String city;

    // Getters and Setters



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
