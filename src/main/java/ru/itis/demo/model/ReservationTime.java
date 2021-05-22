package ru.itis.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationTime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp fromTime;
    private Timestamp toTime;
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private SportItemInfo sportItemInfo;
}
