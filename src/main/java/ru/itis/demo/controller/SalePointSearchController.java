package ru.itis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.demo.model.dto.CriterySearchDto;
import ru.itis.demo.service.SearchService;

@Controller
public class SalePointSearchController {

    @Autowired
    private SearchService searchService;
    @GetMapping("/getpoints")
    public ResponseEntity<?> getSalePoints(@ModelAttribute("criterySearchDto") CriterySearchDto criterySearchDto){
     return null;
    }
}
