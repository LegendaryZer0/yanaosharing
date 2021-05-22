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
    @ManyToOne(cascade = CascadeType.ALL)
    private SportItemInfo sportItemInfo;
}
