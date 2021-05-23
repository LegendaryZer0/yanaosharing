package ru.itis.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.util.PersonGiver;

@Controller
public class UserProfileController {

    @GetMapping("/profile")
    public String getProfilePage(ModelMap map) {
        map.put("user", PersonGiver.get());
        return "profile";
    }
}
