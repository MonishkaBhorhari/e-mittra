
package com.emitrahelp.emitrahelp.controller;

import com.emitrahelp.emitrahelp.entity.City;
import com.emitrahelp.emitrahelp.entity.ServicePost;
import com.emitrahelp.emitrahelp.repository.CityRepository;
import com.emitrahelp.emitrahelp.services.authentication.ServicePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;


import com.emitrahelp.emitrahelp.entity.ServicePost;

import com.emitrahelp.emitrahelp.services.authentication.ServicePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
//
//@RestController
//@RequestMapping("/post-service")
//
//public class ServicePostController {
//
//    @Autowired
//    private ServicePostService servicePostService;
//
//    @GetMapping("/{id}")
//    public ServicePost getServicePostById(@PathVariable Long id) {
//        return servicePostService.getServicePost(id);
//    }
//
//    // Get all service posts
//    @GetMapping("/")
//    public List<ServicePost> getAllServicePosts() {
//        return servicePostService.getAllServicePosts();
//    }
//
//    // Get filtered service posts
//    @GetMapping("/filter")
//    public List<ServicePost> getFilteredServicePosts(@RequestParam(required = false) String category,
//                                                     @RequestParam(required = false) String city) {
//        return servicePostService.getFilteredServicePosts(category, city);
//    }
//
//
//    // Update service post
//    @PutMapping("/{id}")
//    public ServicePost updateServicePost(@PathVariable Long id, @RequestBody ServicePost servicePost) {
//        return servicePostService.updateServicePost(id, servicePost);
//   }
//
//    // Delete service post
//    @DeleteMapping("/{id}")
//    public void deleteServicePost(@PathVariable Long id) {
//        servicePostService.deleteServicePost(id);
//    }
//    @PostMapping
//    public String photoFile(@RequestParam("photoFile") MultipartFile photoFile,
//                            @RequestParam("description") String description,
//                            @RequestParam("email") String email,
//                            @RequestParam("phoneNumber") String phoneNumber,
//                            @RequestParam("city") String city,
//                            @RequestParam("price") double price,
//                            @RequestParam("rating") double rating,
//                            RedirectAttributes redirectAttributes) {
//        try {
//            if (photoFile.isEmpty()) {
//                redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
//                return "redirect:/";
//
//            }
//
//            // Upload directory
//            String uploadDir = "C:/Users/Hi/IdeaProjects/emitrahelp//uploads/";
//            String fileName = System.currentTimeMillis() + "_" + photoFile.getOriginalFilename();
//            Path filePath = Paths.get(uploadDir + fileName);
//
//            // Save file
//            Files.copy(photoFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // Save service post to database
//            ServicePost servicePost = new ServicePost();
//            servicePost.setDescription(description);
//            servicePost.setEmail(email);
//            servicePost.setPhoneNumber(phoneNumber);
//            servicePost.setCity(city);
//            servicePost.setPrice(price);
//            servicePost.setRating(rating);
//            servicePost.setPhotoUrl("/uploads/" + fileName); // Save image path
//
//            servicePostService.createServicePost(servicePost); // Save to DB
//
//            redirectAttributes.addFlashAttribute("message", "Service posted successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            redirectAttributes.addFlashAttribute("message", "File upload failed.");
//        }
//
//        return "redirect:/";
//        // Redirect to home page after successful upload
//    }
//
//}
//
//
//@RestController
//@RequestMapping("/api/services")
//public class ServicePostController {
//
//    @Autowired
//    private ServicePostService servicePostService;
//
//    @GetMapping("/{id}")
//    public ServicePost getServicePostById(@PathVariable Long id) {
//        return servicePostService.getServicePost(id);
//    }
//
//    @GetMapping
//    public List<ServicePost> getAllServicePosts() {
//        return servicePostService.getAllServicePosts();
//    }
//
//    @GetMapping("/filter")
//    public List<ServicePost> getFilteredServicePosts(@RequestParam(required = false) String category,
//                                                     @RequestParam(required = false) String city) {
//        return servicePostService.getFilteredServicePosts(category, city);
//    }
//
//    @PutMapping("/{id}")
//    public ServicePost updateServicePost(@PathVariable Long id, @RequestBody ServicePost servicePost) {
//        return servicePostService.updateServicePost(id, servicePost);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteServicePost(@PathVariable Long id) {
//        servicePostService.deleteServicePost(id);
//    }
//
//    @PostMapping
//    public ResponseEntity<String> photoFile(@RequestParam("photoFile") MultipartFile photoFile,
//                                            @RequestParam("description") String description,
//                                            @RequestParam("email") String email,
//                                            @RequestParam("phoneNumber") String phoneNumber,
//                                            @RequestParam("city") String city,
//                                            @RequestParam("price") double price,
//                                            @RequestParam("rating") double rating) {
//        try {
//            if (photoFile.isEmpty()) {
//                return ResponseEntity.badRequest().body("Please select a file to upload.");
//            }
//
//            String uploadDir = "C:/Users/Hi/IdeaProjects/emitrahelp/uploads/";
//            String fileName = System.currentTimeMillis() + "_" + photoFile.getOriginalFilename();
//            Path filePath = Paths.get(uploadDir + fileName);
//            Files.copy(photoFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            ServicePost servicePost = new ServicePost();
//            servicePost.setDescription(description);
//            servicePost.setEmail(email);
//            servicePost.setPhoneNumber(phoneNumber);
//
//            servicePost.setCity(city);
//            servicePost.setPrice(price);
//            servicePost.setRating(rating);
//            servicePost.setPhotoUrl("/uploads/" + fileName);
//
//            servicePostService.createServicePost(servicePost);
//            return ResponseEntity.ok("Service posted successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed.");
//        }
//    }
//}
@RestController
@RequestMapping("/api/services")
public class ServicePostController {

    @Autowired
    private ServicePostService servicePostService;

    @Autowired
    private CityRepository cityRepository; // ? Add this to fetch City objects

    @PostMapping
    public ResponseEntity<String> photoFile(@RequestParam("photoFile") MultipartFile photoFile,
                                            @RequestParam("description") String description,
                                            @RequestParam("email") String email,
                                            @RequestParam("phoneNumber") String phoneNumber,
                                            @RequestParam("city") String cityName,  // ? Get city name as string
                                            @RequestParam("price") double price,
                                            @RequestParam("rating") double rating) {
        try {
            if (photoFile.isEmpty()) {
                return ResponseEntity.badRequest().body("Please select a file to upload.");
            }

            // ? Upload photo
            String uploadDir = "C:/Users/Hi/IdeaProjects/emitrahelp/uploads/";
            String fileName = System.currentTimeMillis() + "_" + photoFile.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.copy(photoFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // ? Fetch City object using city name
            City city = cityRepository.findByName(cityName);
            if (city == null) {
                return ResponseEntity.badRequest().body("City not found: " + cityName);
            }

            // ? Set City object to ServicePost
            ServicePost servicePost = new ServicePost();
            servicePost.setDescription(description);
            servicePost.setEmail(email);
            servicePost.setPhoneNumber(phoneNumber);
            servicePost.setCity(city); // ? Correct assignment
            servicePost.setPrice(price);
            servicePost.setRating(rating);
            servicePost.setPhotoUrl("/uploads/" + fileName);

            servicePostService.createServicePost(servicePost);
            return ResponseEntity.ok("Service posted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed.");
        }
    }
}
