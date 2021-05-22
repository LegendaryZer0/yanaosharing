package ru.itis.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.model.dto.AvailableSearchDto;
import ru.itis.demo.service.MarkerService;

@RestController
@Slf4j
public class SaveMarkerController {


    @Autowired
    private MarkerService markerService;
    @PostMapping("/addMarker")
    public void saveMarker(@RequestBody AvailableSearchDto dto){
        //TODO Эта хрень не обрабатывает JSON с фронта
        log.info("Starting saving   " + dto.toString());
       // markerService.saveMarker(dto,principal);
    }
}
