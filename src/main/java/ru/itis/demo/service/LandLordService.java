package ru.itis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.model.*;
import ru.itis.demo.repository.LandlordRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class LandLordService  {
    @Autowired
    private LandlordRepository landlordRepository;
    @Transactional
    public void saveLandlordWithPointOfSale(){
        landlordRepository.save(Landlord.builder()

                .email("email.@gmail.com")
                .password("Wonderfullpassword")
                .phone("+732839842")
                .pointOfSales(Collections.singletonList(PointOfSale.builder()
                        .nameOfOrganization("SportFIX")
                        .positionX(34.43523)
                        .positionY(21.42545)

                        .sportInventoryList(Collections.singletonList(SportInventory.builder()
                                .nameOfItem("Самокат")
                                .sportItemInfoList(Collections.singletonList(SportItemInfo.builder()
                                        .price(500L)
                                        .state(SportItemInfo.State.Available)
                                        .reservationTimes(Collections.singletonList(ReservationTime.builder()
                                                .fromTime(Timestamp.valueOf(LocalDateTime.now()))
                                                .toTime(Timestamp.valueOf(LocalDateTime.now().plusHours(2)))
                                                .build()))
                                        .build()))
                                .build()))
                        .build()))
                .build());
        landlordRepository.save(Landlord.builder()

                .email("тщьфшд.@gmail.com")
                .password("Wonderfullpassword132234523")
                .phone("+732839823432442")
                .pointOfSales(Collections.singletonList(PointOfSale.builder()
                        .nameOfOrganization("RUNsprort")
                        .positionX(344.43523423)
                        .positionY(214.42532445)

                        .sportInventoryList(Collections.singletonList(SportInventory.builder()
                                .nameOfItem("Велосипед")
                                .sportItemInfoList(Collections.singletonList(SportItemInfo.builder()
                                        .price(400L)
                                        .state(SportItemInfo.State.Available)
                                        .reservationTimes(Collections.singletonList(ReservationTime.builder()
                                                .fromTime(Timestamp.valueOf(LocalDateTime.now()))
                                                .toTime(Timestamp.valueOf(LocalDateTime.now().plusHours(2)))
                                                .build()))
                                        .build()))
                                .build()))
                        .build()))
                .build());
    }
}
