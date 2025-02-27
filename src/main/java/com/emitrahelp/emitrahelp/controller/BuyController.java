package com.emitrahelp.emitrahelp.controller;

import com.emitrahelp.emitrahelp.entity.ServicePost;
import com.emitrahelp.emitrahelp.services.authentication.ServicePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuyController {

    @Autowired
    private ServicePostService servicePostService;
//
//    // Display the selected service details on the Buy Page
//    @GetMapping("/buy-service/{id}")
//    public String showBuyPage(@PathVariable Long id, Model model) {
//        ServicePost servicePost = servicePostService.getServicePostById(id);
//        if (servicePost == null) {
//            model.addAttribute("errorMessage", "Service not found.");
//            return "error"; // Make sure error.html exists
//        }
//        model.addAttribute("servicePost", servicePost);
//        return "buy-service"; // Ensure buy-service.html exists
//    }
//
//    // Process the payment (Mock implementation)
//    @PostMapping("/buy-service/{id}")
//    public String processPayment(@PathVariable Long id, Model model) {
//        ServicePost servicePost = servicePostService.getServicePostById(id);
//        if (servicePost == null) {
//            model.addAttribute("errorMessage", "Service not found.");
//            return "error";
//        }
//        // Mock payment logic (you can integrate a real payment gateway here)
//        model.addAttribute("successMessage", "Payment successful! You have purchased the service.");
//        return "buy-confirmation"; // Ensure buy-confirmation.html exists
//    }
}
