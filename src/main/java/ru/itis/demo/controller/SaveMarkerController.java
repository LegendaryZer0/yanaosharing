package ru.itis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.model.dto.AvailibleSearchDto;
import ru.itis.demo.service.MarkerService;

import java.security.Principal;

@RestController
public class SaveMarkerController {


    @Autowired
    private MarkerService markerService;
    @PostMapping("/addMarker")
    public void saveMarker(@RequestBody AvailibleSearchDto dto, @AuthenticationPrincipal Principal principal){
        markerService.saveMarker(dto,principal);
    }
}
