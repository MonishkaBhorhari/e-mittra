//package com.emitrahelp.emitrahelp.services.authentication;//package com.emitrahelp.emitrahelp.services.authentication;//package com.emitrahelp.emitrahelp.services.authentication;//package com.emitrahelp.emitrahelp.services.authentication;
//
//import com.emitrahelp.emitrahelp.Enum.UserRole;
//import com.emitrahelp.emitrahelp.dto.SignupRequestDTO;
//import com.emitrahelp.emitrahelp.dto.UserDto;
//import com.emitrahelp.emitrahelp.entity.User;
//import com.emitrahelp.emitrahelp.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthServiceImpl implements AuthService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public UserDto signupClient(SignupRequestDTO signupRequestDTO) {
//        User user = new User();
//
//        user.setName(signupRequestDTO.getName());
//        user.setLastname(signupRequestDTO.getLastname());
//        user.setEmail(signupRequestDTO.getEmail());
//        user.setPhone(signupRequestDTO.getPhone());
//        user.setCity(signupRequestDTO.getCity());
//        user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword())); // Encoded password
//        user.setRole(UserRole.CLIENT);
//        return userRepository.save(user).getDto();
//    }
//
//
//    public Boolean presentByEmail(String email) {
//        return userRepository.findFirstByEmail(email) != null;
//    }
//
//
//    public UserDto signupProvider(SignupRequestDTO signupRequestDTO) {
//        User user = new User();
//        user.setName(signupRequestDTO.getName());
//        user.setEmail(signupRequestDTO.getEmail());
//        user.setPhone(signupRequestDTO.getPhone());
//        user.setCity(signupRequestDTO.getCity());
//        user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword())); // Encoded password
//        user.setRole(UserRole.PROVIDER);
//        return userRepository.save(user).getDto();
//    }
//
//    @Override
//    public boolean validateUser(String email, String password) {
//        // Validation logic can be added here if needed.
//        return false;
//    }
//
//
//}
package com.emitrahelp.emitrahelp.services.authentication;

import com.emitrahelp.emitrahelp.Enum.UserRole;
import com.emitrahelp.emitrahelp.dto.SignupRequestDTO;
import com.emitrahelp.emitrahelp.dto.UserDto;
import com.emitrahelp.emitrahelp.entity.User;
import com.emitrahelp.emitrahelp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto signupClient(SignupRequestDTO signupRequestDTO) {
        if (presentByEmail(signupRequestDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists!");
        }

        User user = new User();
        user.setName(signupRequestDTO.getName());
        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setCity(signupRequestDTO.getCity());
        user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword())); // Encoded password
        user.setRole(UserRole.CLIENT);
        return userRepository.save(user).getDto();
    }

    public UserDto signupProvider(SignupRequestDTO signupRequestDTO) {
        if (presentByEmail(signupRequestDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists!");
        }

        User user = new User();
        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setCity(signupRequestDTO.getCity());
        user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword())); // Encoded password
        user.setRole(UserRole.PROVIDER);
        return userRepository.save(user).getDto();
    }

    public Boolean presentByEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }

    @Override
    public boolean validateUser(String email, String password) {
        User user = userRepository.findFirstByEmail(email);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}
