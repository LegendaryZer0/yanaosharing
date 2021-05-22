package ru.itis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.model.Landlord;
import ru.itis.demo.model.dto.AvailableSearchDto;

import java.security.Principal;

@Service
public class MarkerService {
    @Autowired
    private LandLordService landLordService;

    public void saveMarker(AvailableSearchDto dto, Principal principal){
        Landlord landlord =landLordService.findLandlordByName(principal.getName());
       // landlord.getPointOfSales().add();
    }
}
