package ru.itis.demo.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp fromTime;
    private Timestamp toTime;
    @JoinColumn(name = "sport_item_info")
    @ManyToOne(cascade = CascadeType.ALL)

    private SportItemInfo sportItemInfo;
}
