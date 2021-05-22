package ru.itis.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profilei")
    public String getProfilePage(){
        return "profilei";
    }
}
