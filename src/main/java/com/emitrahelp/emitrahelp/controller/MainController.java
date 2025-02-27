//package com.emitrahelp.emitrahelp.controller;
//
//
//import com.emitrahelp.emitrahelp.entity.ServicePost;
//
//import com.emitrahelp.emitrahelp.dto.SignupRequestDTO;
//
//import com.emitrahelp.emitrahelp.services.authentication.AuthService;
//import com.emitrahelp.emitrahelp.services.authentication.ServicePostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class MainController {
//
//    @Autowired
//    private ServicePostService servicePostService;
//
//    @Autowired
//    private AuthService authService;
//
//    @GetMapping("/")
//    public String showHomePage(Model model) {
//        List<ServicePost> services = servicePostService.getAllServicePosts();
//        model.addAttribute("services", services);
//        return "home";
//    }
//    @GetMapping("/post-service")
//    public String showPostForm(Model model) {
//        model.addAttribute("servicePost", new ServicePost());
//        List<ServicePost> services = servicePostService.getAllServicePosts();
//        model.addAttribute("services", services);
//        return "post-service"; // Render post-service.html
//    }
//
////    @GetMapping("/post-service")
////    public String showPostForm(Model model) {
////        model.addAttribute("servicePost", new ServicePost());
////        return "post-service";
////    }
//
//    @PostMapping("/post-service")
//    public String createServicePost(@ModelAttribute ServicePost servicePost, Model model) {
//        try {
//            servicePostService.createServicePost(servicePost);
//            return "redirect:/post-service"; // Redirect to post-service page after creation
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Error while creating the service post.");
//            return "post-service"; // Return back to the post-service form in case of an error
//        }
//    }
//
//    @GetMapping("/post-service/update/{id}")
//    public String showUpdateForm(@PathVariable Long id, Model model) {
//        ServicePost servicePost = servicePostService.getServicePost(id);
//        model.addAttribute("servicePost", servicePost);
//        return "update-service";
//    }
//
//    @PostMapping("/post-service/update/{id}")
//    public String updateServicePost(@PathVariable Long id, @ModelAttribute ServicePost servicePost, Model model) {
//        try {
//            servicePostService.updateServicePost(id, servicePost);
//            return "redirect:/post-service";
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Error while updating the service post.");
//            return "update-service";
//        }
//    }
//
//    @PostMapping("/post-service/delete/{id}")
//    public String deleteServicePost(@PathVariable Long id, Model model) {
//        try {
//            servicePostService.deleteServicePost(id);
//            return "redirect:/post-service";
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Error while deleting the service post.");
//            return "error";
//        }
//    }
//
//    @GetMapping("/register")
//    public String showRegisterPage(Model model) {
//        model.addAttribute("signupRequestDTO", new SignupRequestDTO());
//        return "register";
//    }
//
//    @PostMapping("/client/sign-up")
//    public String signupClient(@ModelAttribute SignupRequestDTO signupRequestDTO, Model model) {
//        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
//            model.addAttribute("errorMessage", "Client already exists.");
//            return "register";
//        }
//        authService.signupClient(signupRequestDTO);
//        return "signup-success";
//    }
//    @GetMapping("/login")
//    public String showLoginError(Model model) {
//        model.addAttribute("errorMessage", "Invalid username or password.");
//        return "login"; // Show login page with error message
//    }
//}
package com.emitrahelp.emitrahelp.controller;

import com.emitrahelp.emitrahelp.dto.UserDto;
import com.emitrahelp.emitrahelp.dto.SignupRequestDTO;
import com.emitrahelp.emitrahelp.services.authentication.AuthService;
import com.emitrahelp.emitrahelp.services.authentication.ServicePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:5500")
public class MainController {

    private final ServicePostService servicePostService;
    private final AuthService authService;
//    @GetMapping("/pan-verification")
//    public String panVerification() {
//        return "pan_verification";  // यह templates/pan_verification.html को रेंडर करेगा
//    }

    @Autowired
    public MainController(ServicePostService servicePostService, AuthService authService) {
        this.servicePostService = servicePostService;
        this.authService = authService;
    }

//    // Home Page - Display All Service Posts
//    @GetMapping
//    public String showHomePage(Model model) {
//        List<ServicePost> services = servicePostService.getAllServicePosts();
//        model.addAttribute("services", services);
//        return "home";
//    }

    // Show Form to Post a Service
//    @GetMapping("/post-service")
//    public String showPostForm(Model model) {
//        model.addAttribute("servicePost", new ServicePost());
//        model.addAttribute("services", servicePostService.getAllServicePosts());
//        return "post-service";
//    }


    // Show Update Form
//    @GetMapping("/post-service/update/{id}")
//    public String showUpdateForm(@PathVariable Long id, Model model) {
//        ServicePost servicePost = servicePostService.getServicePost(id);
//        if (servicePost == null) {
//            model.addAttribute("errorMessage", "Service post not found.");
//            return "error";
//        }
//        model.addAttribute("servicePost", servicePost);
//        return "update-service";
//    }

    // Update a Service Post
//    @PostMapping("/post-service/update/{id}")
//    public String updateServicePost(@PathVariable Long id, @ModelAttribute ServicePost servicePost, Model model) {
//        try {
//            servicePostService.updateServicePost(id, servicePost);
//            return "redirect:/post-service";
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Error while updating the service post.");
//            return "update-service";
//        }
//    }

//    // Delete a Service Post
//    @PostMapping("/post-service/delete/{id}")
//    public String deleteServicePost(@PathVariable Long id, Model model) {
//        try {
//            servicePostService.deleteServicePost(id);
//            return "redirect:/post-service";
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Error while deleting the service post.");
//            return "error";
//        }
//    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("signupRequestDTO", new SignupRequestDTO());
        return "register";

    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") SignupRequestDTO signupRequestDTO, Model model) {
        UserDto savedUser = authService.signupClient(signupRequestDTO);
        model.addAttribute("user", savedUser);
        return "signup-success";
    }

@PostMapping("/client/sign-up")
public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO) {
    try {
        System.out.println("Received Request: " + signupRequestDTO);

        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists.");
        }

        UserDto user = authService.signupClient(signupRequestDTO);
        return ResponseEntity.ok(user);
    } catch (Exception e) {
        e.printStackTrace(); // This will log the full error in the console
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed: " + e.getMessage());
    }
}
    @PostMapping("/provider/sign-up")
    public ResponseEntity<?> signupProvider(@RequestBody SignupRequestDTO signupRequestDTO) {
        try {
            if (authService.presentByEmail(signupRequestDTO.getEmail())) {
                return ResponseEntity.badRequest().body("Email already exists.");
            }

            UserDto user = authService.signupProvider(signupRequestDTO);

            // Return a response with a redirect URL to the service provider portal
            Map<String, String> response = new HashMap<>();
            response.put("message", "Registration successful!");
            response.put("redirectUrl", "/service-provider-dashboard"); // Change to your actual dashboard URL

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed: " + e.getMessage());
        }
    }



    @GetMapping("/login")
    public String showLoginError(Model model) {
        model.addAttribute("errorMessage", "Invalid username or password.");
        return "login"; // Show login page with error message
    }
}
