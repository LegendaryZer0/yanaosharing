package ru.itis.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportInventory {
    @JoinColumn(name = "point_of_sale")
    @ManyToOne(cascade = CascadeType.ALL)
    private  PointOfSale pointOfSale;

    @Column(nullable = false,name = "sport_iteminfo_list")
    @OneToMany(mappedBy = "sportInventory",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<SportItemInfo> sportItemInfoList;
    @Id
    private String nameOfItem; //САМОКАТ
}
