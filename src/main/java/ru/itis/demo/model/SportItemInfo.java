package ru.itis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportItemInfo {
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private SportInventory sportInventory;
    @Enumerated(EnumType.STRING)
    private  State state;

    @OneToMany(mappedBy = "sportItemInfo")
    private List<ReservationTime> reservationTimes;

    public enum State{
        Available,NOTAVAILABLE
    }

}
