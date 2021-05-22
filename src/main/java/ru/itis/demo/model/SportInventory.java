package ru.itis.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportInventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private  PointOfSale pointOfSale;

    @Column(nullable = false)
    @OneToMany(mappedBy = "sportInventory",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SportItemInfo> sportItemInfoList = new ArrayList<>();

    private String nameOfItem;
}
