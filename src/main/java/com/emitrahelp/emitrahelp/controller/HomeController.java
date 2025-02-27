
package com.emitrahelp.emitrahelp.controller;

import com.emitrahelp.emitrahelp.entity.ServicePost;
import com.emitrahelp.emitrahelp.services.authentication.ServicePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }
    @Autowired
    private ServicePostService servicePostService;
//
//    @GetMapping("/home")
//    public String homePage(Model model) {
//        List<ServicePost> services = servicePostService.getAllServicePosts();
//        model.addAttribute("services", services);
//        return "home";
//    }
}