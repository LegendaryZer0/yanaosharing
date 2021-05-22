package ru.itis.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.model.dto.CriterySearchDto;
import ru.itis.demo.service.SearchService;

@Controller
@Slf4j
public class SalePointSearchController {

    @Autowired
    private SearchService searchService;
    @GetMapping("/getpoints")
    public ResponseEntity<?> getSalePoints(@ModelAttribute("criterySearchDto") CriterySearchDto criterySearchDto){
     return null;
    }

    @RequestMapping("/showPointOfSale")
    public String showPointOfSale(@RequestParam("pointOfSaleId")Long pointOfSaleId, Model model){
        model.addAttribute("pointOfSale", searchService.getPointOfSale(pointOfSaleId).get());
        return "pointOfSale";
    }
}
