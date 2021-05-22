package ru.itis.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.model.*;
import ru.itis.demo.repository.LandlordRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
@Slf4j
@Service
public class LandLordService  {
    @Autowired
    private LandlordRepository landlordRepository;
    @Transactional
    public void saveLandlordWithPointOfSale(){
/*       Landlord landlord= Landlord.builder()
                .email("email.@gmail.com")
                .password("Wonderfullpassword")
                .phone("+732839842")

                .build();
       log.info(landlord.toString());


       landlord.getPointOfSales().add(PointOfSale.builder() //Todo я
               .nameOfOrganization("SportFIX")
               .positionX(34.43523)
               .landlord(landlord) //
               .positionY(21.42545) .build());
       landlordRepository.save(landlord);*/
        Landlord landlord  =Landlord.builder()

                .email("email.@gmail.com")
                .password("Wonderfullpassword")
                .phone("+732839842")
                .pointOfSales(Collections.singleton(PointOfSale.builder()
                        .nameOfOrganization("SportFIX")
                        .positionX(34.43523)
                        .positionY(21.42545)



                        .sportInventoryList(Collections.singleton(SportInventory.builder() //Todo ага по моему  всё в not null падёт
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
                .build();

        landlordRepository.save(landlord);
        landlordRepository.save(Landlord.builder()

                .email("тщьфшд.@gmail.com")
                .password("Wonderfullpassword132234523")
                .phone("+732839823432442")
                .pointOfSales(Collections.singleton(PointOfSale.builder()
                        .nameOfOrganization("RUNsprort")
                        .positionX(344.43523423)
                        .positionY(214.42532445)

                        .sportInventoryList(Collections.singleton(SportInventory.builder()
                                .nameOfItem("Велосипед")
                                .sportItemInfoList(Collections.singleton(SportItemInfo.builder()
                                        .price(400L)
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
