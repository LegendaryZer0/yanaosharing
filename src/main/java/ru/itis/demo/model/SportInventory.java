package ru.itis.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportInventory {
    @Id
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private  PointOfSale pointOfSale;

    @OneToMany(mappedBy = "sportInventory",fetch = FetchType.EAGER)
    private List<SportItemInfo> sportItemInfoList;

    private String nameOfItem;
}
