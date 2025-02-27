package com.emitrahelp.emitrahelp.services.authentication;//package com.emitrahelp.emitrahelp.services.authentication;//package com.emitrahelp.emitrahelp.services.authentication;//package com.emitrahelp.emitrahelp.services.authentication;
//
//
//
//import com.emitrahelp.emitrahelp.entity.ServicePost;
//import com.emitrahelp.emitrahelp.repository.ServicePostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ServicePostService {
//
//    @Autowired
//    private ServicePostRepository servicePostRepository;
//
//    // Method to create a new service post
//    public ServicePost createServicePost(ServicePost servicePost) {
//        return servicePostRepository.save(servicePost);
//    }
//
//    // Method to get all service posts
//    public List<ServicePost> getAllServicePosts() {
//        return servicePostRepository.findAll();
//    }
//
//    // Method to get a service post by ID
//    public ServicePost getServicePostById(Long id) {
//        return servicePostRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Service post not found with id: " + id));
//    }
//
//    // Method to update a service post
//    public ServicePost updateServicePost(Long id, ServicePost servicePost) {
//        // Check if the service post exists
//        if (!servicePostRepository.existsById(id)) {
//            throw new RuntimeException("Service post not found with id: " + id);
//        }
//        servicePost.setId(id); // Set the ID to ensure the correct post is updated
//        return servicePostRepository.save(servicePost);
//    }
//
//    // Method to delete a service post
//    public void deleteServicePost(Long id) {
//        if (!servicePostRepository.existsById(id)) {
//            throw new RuntimeException("Service post not found with id: " + id);
//        }
//        servicePostRepository.deleteById(id);
//    }
//
//
//
//
//    public ServicePost getServicePost(Long id) {
//        return servicePostRepository.getReferenceById(id);
//    }
//    public List<ServicePost> getFilteredServicePosts(String category, String city) {
//        return servicePostRepository.findByCategoryAndCity(category, city);
//    }
//    // Method to get filtered service posts by category and city
//
//
//}


//import com.emitrahelp.emitrahelp.entity.ServicePost;
//import com.emitrahelp.emitrahelp.repository.ServicePostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ServicePostService {
//
//    @Autowired
//    private ServicePostRepository servicePostRepository;
//
//    // Get all service posts
//    public List<ServicePost> getAllServicePosts() {
//        return servicePostRepository.findAll();
//    }
//
//    // Get a single service post by ID
//    public ServicePost getServicePostById(Long id) {
//        return servicePostRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Service post not found with id: " + id));
//    }
//
//    // Create a new service post
//    public ServicePost createServicePost(ServicePost servicePost) {
//        return servicePostRepository.save(servicePost);
//    }
//
//    // Update an existing service post
//    public ServicePost updateServicePost(Long id, ServicePost updatedServicePost) {
//        return servicePostRepository.findById(id).map(existingPost -> {
//            existingPost.setPostDate(updatedServicePost.getPostDate());
//            existingPost.setDescription(updatedServicePost.getDescription());
//            existingPost.setCategory(updatedServicePost.getCategory());
//            existingPost.setId(updatedServicePost.getId());
//            existingPost.setPhoneNumber(updatedServicePost.getPhoneNumber());
//            existingPost.setEmail(updatedServicePost.getEmail());
//            return servicePostRepository.save(existingPost);
//        }).orElseThrow(() -> new RuntimeException("Service post not found with id: " + id));
//    }
//
//    // Delete a service post
//    public void deleteServicePost(Long id) {
//        if (!servicePostRepository.existsById(id)) {
//            throw new RuntimeException("Service post not found with id: " + id);
//        }
//        servicePostRepository.deleteById(id);
//    }
//
//    // Get filtered service posts based on category and city
//    public List<ServicePost> getFilteredServicePosts(String category, String city) {
//        return servicePostRepository.findByCategoryAndCity(category, city);
//    }
//
//    public ServicePost getServicePost(Long id) {
//        return servicePostRepository.getReferenceById(id);
//    }
//}

//
//import com.emitrahelp.emitrahelp.entity.ServicePost;
//import com.emitrahelp.emitrahelp.repository.ServicePostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ServicePostService {
//
//    @Autowired
//    private ServicePostRepository servicePostRepository;
////
////    // Create a new service post
////    public ServicePost createServicePost(ServicePost servicePost) {
////        return servicePostRepository.save(servicePost);
////    }
//    public ServicePost save(ServicePost servicePost) {
//        System.out.println("Saving post with photo URL: " + servicePost.getPhotoUrl());
//        return servicePostRepository.save(servicePost);
//    }
//    public ServicePost createServicePost(ServicePost servicePost) {
//        System.out.println("Saving Post: " + servicePost.getPhotoUrl()); // ✅ Debugging
//
//        return servicePostRepository.save(servicePost);
//    }
//
//    // Get all service posts
//    public List<ServicePost> getAllServicePosts() {
//        return servicePostRepository.findAll();
//    }
//
//    // Get a service post by ID
//    public ServicePost getServicePost(Long id) {
//        return servicePostRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Service post not found with id: " + id));
//    }
//
//    // Update a service post
//    public ServicePost updateServicePost(Long id, ServicePost servicePost) {
//        if (!servicePostRepository.existsById(id)) {
//            throw new RuntimeException("Service post not found with id: " + id);
//        }
//        servicePost.setId(id);
//        return servicePostRepository.save(servicePost);
//    }
//
//    // Delete a service post
//    public void deleteServicePost(Long id) {
//        if (!servicePostRepository.existsById(id)) {
//            throw new RuntimeException("Service post not found with id: " + id);
//        }
//        servicePostRepository.deleteById(id);
//    }
//
//    // Get filtered service posts by category and city
//    public List<ServicePost> getFilteredServicePosts(String category, String city) {
//        return servicePostRepository.findByCategoryAndCity(category, city);
//    }
//
//    public ServicePost getServicePostById(Long id) {
//        return servicePostRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Service post not found with id: " + id));
//    }
//}
//
//import com.emitrahelp.emitrahelp.entity.City;
//import com.emitrahelp.emitrahelp.entity.ServicePost;
//import com.emitrahelp.emitrahelp.repository.CityRepository;
//import com.emitrahelp.emitrahelp.repository.ServicePostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//
//@Service
//public class ServicePostService {
//
//    @Autowired
//    private ServicePostRepository servicePostRepository;
//
//    @Autowired
//    private CityRepository cityRepository;
//
//    // ✅ Save service post with image upload
//    public ServicePost createServicePost(ServicePost servicePost, String cityName, byte[] photoBytes, String originalFilename) throws IOException {
//        // 🔥 Upload photo
//        String uploadDir = "C:/Users/Hi/IdeaProjects/emitrahelp/uploads/";
//        String fileName = System.currentTimeMillis() + "_" + originalFilename;
//        Path filePath = Paths.get(uploadDir + fileName);
//        Files.write(filePath, photoBytes); // ✅ Save image to local directory
//
//        // ✅ Set uploaded photo URL
//        servicePost.setPhotoUrl("/uploads/" + fileName);
//
//        // ✅ Fetch and set City object
//        City city = cityRepository.findByName(cityName);
//        if (city == null) {
//            throw new IllegalArgumentException("City not found: " + cityName);
//        }
//        servicePost.setCity(city);
//
//        return servicePostRepository.save(servicePost); // ✅ Save service post with image and city
//    }
//    // ✅ Fetch services posted by provider's email
//    public List<ServicePost> getServicePostsByEmail(String email) {
//        return servicePostRepository.findByEmail(email);
//    }
//}

import com.emitrahelp.emitrahelp.entity.City;
import com.emitrahelp.emitrahelp.entity.ServicePost;
import com.emitrahelp.emitrahelp.repository.CityRepository;
import com.emitrahelp.emitrahelp.repository.ServicePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ServicePostService {

    @Autowired
    private ServicePostRepository servicePostRepository;

    @Autowired
    private CityRepository cityRepository;

    // ✅ Save service post with image upload
    public ServicePost createServicePost(ServicePost servicePost, String cityName, byte[] photoBytes, String originalFilename) throws IOException {
        return null;
    }

    // ✅ Fetch services posted by provider's email
    public List<ServicePost> getServicePostsByEmail(String email) {
        return servicePostRepository.findByEmail(email);
    }

    // ✅ Fetch all service posts (for homepage display)
    public List<ServicePost> getAllServicePosts() {
        return servicePostRepository.findAll();
    }

    public void createServicePost(ServicePost servicePost) {
    }
}
