package ru.itis.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationTime {

    @Id
    private Long id;

    private Timestamp fromTime;
    private Timestamp toTime;
    @ManyToOne
    private SportItemInfo sportItemInfo;
}
