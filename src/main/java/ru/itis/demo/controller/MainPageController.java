package ru.itis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.demo.service.LandLordService;

@Controller
public class MainPageController {
    @Autowired
    private LandLordService landLordService;

    @GetMapping("/yanaosharing")
    public String getMainPage() {
//        landLordService.saveLandlordWithPointOfSale();
        return "mainPage";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
