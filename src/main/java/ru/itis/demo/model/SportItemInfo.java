package ru.itis.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private SportInventory sportInventory;
    @Enumerated(EnumType.STRING)
    private  State state;
    @Column(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "sportItemInfo",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<ReservationTime> reservationTimes = new ArrayList<>();
    @Column(nullable = false)
    private Long price;

    public enum State{
        Available,NotAvailable
    }

}
