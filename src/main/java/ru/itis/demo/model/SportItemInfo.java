package ru.itis.demo.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportItemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "sport_inventory")
    @ManyToOne(cascade = CascadeType.ALL)
    private SportInventory sportInventory;
    @Enumerated(EnumType.STRING)
    private  State state;
    @Column(nullable = false)

    @OneToMany(mappedBy = "sportItemInfo",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ReservationTime> reservationTimes;
    @Column(nullable = false)
    private Long price;

    public enum State{
        Available,NOTAVAILABLE
    }

}
