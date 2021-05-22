package ru.itis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.service.SearchService;

@Controller
public class GetItamNamesController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/getNamesOfItems")
    public ResponseEntity<?> getItemNames() {
        return ResponseEntity.ok(searchService.findAllNameOfItems());
    }
}
