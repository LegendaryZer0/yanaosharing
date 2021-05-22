package ru.itis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.model.*;
import ru.itis.demo.repository.LandlordRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class LandLordService  {
    @Autowired
    LandlordRepository landlordRepository;
    public void saveLandlordWithPointOfSale(){
        landlordRepository.save(Landlord.builder()

                .email("email.@gmail.com")
                .password("Wonderfullpassword")
                .phone("+732839842")
                .pointOfSales(Collections.singleton(PointOfSale.builder()
                        .nameOfOrganization("SportFIX")
                        .positionX(34.43523)
                        .positionY(21.42545)

                        .sportInventoryList(Collections.singletonList(SportInventory.builder()
                                .nameOfItem("Самокат")
                                .sportItemInfoList(Collections.singleton(SportItemInfo.builder()
                                        .price(500L)
                                        .state(SportItemInfo.State.Available)
                                        .reservationTimes(Collections.singleton(ReservationTime.builder()
                                                .fromTime(Timestamp.valueOf(LocalDateTime.now()))
                                                .toTime(Timestamp.valueOf(LocalDateTime.now().plusHours(2)))
                                                .build()))
                                        .build()))
                                .build()))
                        .build()))
                .build());
    }
}
