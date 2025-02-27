//package com.emitrahelp.emitrahelp.controller;
//
//import com.emitrahelp.emitrahelp.services.authentication.PanVerificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;

//package com.emitrahelp.emitrahelp.controller;
//
//import com.emitrahelp.emitrahelp.services.authentication.PanVerificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/pan")
//public class PanController {
//
//    @Autowired
//    private PanVerificationService panVerificationService;
//
//    @PostMapping("/verify")
//    public String verifyPan(@RequestParam String panNumber) {
//        // सर्विस कॉल
//        return panVerificationService.verifyPan(panNumber);
//    }
////}
////
//@RestController
//@RequestMapping("/api/pan")
//public class PanVerificationController {
//
//    @Autowired
//    private PanVerificationService panVerificationService;
//
//    @PostMapping("/verify")
//    public ResponseEntity<String> verifyPan(@RequestBody Map<String, String> requestData) {
//        String panNumber = requestData.get("panNumber");
//
//        if (panNumber == null || panNumber.isEmpty()) {
//            return ResponseEntity.badRequest().body("PAN Number is required!");
//        }
//
//        String response = panVerificationService.verifyPan(panNumber);
//        return ResponseEntity.ok(response);
//    }
//}
