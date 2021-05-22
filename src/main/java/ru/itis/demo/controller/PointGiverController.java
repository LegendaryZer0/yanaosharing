package ru.itis.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.service.PointOfSaleService;

@RestController
@Slf4j
public class PointGiverController {
    @Autowired
    private PointOfSaleService pointOfSaleService;

    @GetMapping("/getPoints")
    public ResponseEntity<?> findUserPoints(Model model) {
        log.info("GG ");
        model.addAttribute("allMarkers", pointOfSaleService.findAll());
        model.addAttribute("countOfMarkers", pointOfSaleService.findAll().size());
        log.info("allMarkers : " + model.getAttribute("allMarkers"));
        log.info(("count: " + model.getAttribute("countOfMarkers")));
        return ResponseEntity.ok(pointOfSaleService.findAll());
    }
}
