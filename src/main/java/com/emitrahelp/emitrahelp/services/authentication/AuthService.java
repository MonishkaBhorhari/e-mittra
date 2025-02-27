package com.emitrahelp.emitrahelp.services.authentication;

import com.emitrahelp.emitrahelp.dto.SignupRequestDTO;

import com.emitrahelp.emitrahelp.dto.UserDto;

public interface AuthService {
    UserDto signupClient(SignupRequestDTO signupRequestDTO);
    Boolean presentByEmail(String email);

    boolean validateUser(String email, String password);

    UserDto signupProvider(SignupRequestDTO signupRequestDTO);
}
