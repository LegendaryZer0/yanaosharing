package ru.itis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.service.PointOfSaleService;

@RestController
public class UserGiverController {
    @Autowired
    private PointOfSaleService pointOfSaleService;
    @GetMapping("/getPoints")
    public ResponseEntity<?> findUserPoints(){
        return ResponseEntity.ok(pointOfSaleService.findAll());
    }
}
