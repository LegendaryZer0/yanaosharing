package ru.itis.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {

    @GetMapping("/profile")
    public String getProfilePage(ModelMap map) {
//        map.addAttribute("rc", );
//        map.addAttribute("user", );
        return "profile";
    }
}
