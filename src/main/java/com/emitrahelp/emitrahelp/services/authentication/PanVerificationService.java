//package com.emitrahelp.emitrahelp.services.authentication;
//
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class PanVerificationService {
//
//    public String verifyPan(String panNumber) {
//        String url = "https://pan-card-verification1.p.rapidapi.com/v3/tasks/sync/verify_with_source/ind_pan";
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        // HTTP Headers सेट करें
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("x-rapidapi-host", "pan-card-verification1.p.rapidapi.com");
//        headers.set("x-rapidapi-key", "Your_RapidAPI_Key"); // यहां अपना key डालें
//
//        // JSON Payload बनाएं
//        Map<String, Object> payload = new HashMap<>();
//        payload.put("task_id", "74f4c926-250c-43ca-9c53-453e87ceacd1");  // उदाहरण के लिए, स्थिर मान
//        payload.put("group_id", "8e16424a-58fc-4ba4-ab20-5bc8e7c3c41e"); // उदाहरण के लिए, स्थिर मान
//
//        Map<String, String> data = new HashMap<>();
//        data.put("id_number", panNumber); // उपयोगकर्ता द्वारा दिया गया PAN नंबर
//        payload.put("data", data);
//
//        // Request Entity तैयार करें
//        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
//
//        // POST request करें
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//
//        return response.getBody();
//    }
////}
//package com.emitrahelp.emitrahelp.services.authentication;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.HttpStatusCodeException;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class PanVerificationService {
//
//    @Value("${rapidapi.key}")  // ✅ Load API Key from properties
//    private String rapidApiKey;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    public String verifyPan(String panNumber) {
//        String url = "https://pan-card-verification1.p.rapidapi.com/v3/tasks/sync/verify_with_source/ind_pan";
//
//        // ✅ Set Headers
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("X-RapidAPI-Host", "pan-card-verification1.p.rapidapi.com");
//        headers.set("X-RapidAPI-Key", rapidApiKey);  // ✅ Secure API Key
//
//        // ✅ JSON Payload
//        Map<String, Object> payload = new HashMap<>();
//        payload.put("task_id", "74f4c926-250c-43ca-9c53-453e87ceacd1");
//        payload.put("group_id", "8e16424a-58fc-4ba4-ab20-5bc8e7c3c41e");
//
//        Map<String, String> data = new HashMap<>();
//        data.put("id_number", panNumber);
//        payload.put("data", data);
//
//        // ✅ Prepare Request Entity
//        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
//
//        try {
//            // ✅ Send POST Request
//            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//            return response.getBody();
//        } catch (HttpStatusCodeException e) {
//            // ✅ Handle API Errors
//            return "Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString();
//        } catch (Exception e) {
//            // ✅ Handle Other Errors
//            return "Error: " + e.getMessage();
//        }
//    }
//}
