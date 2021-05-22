package ru.itis.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SportInventory {
    @ManyToOne(cascade = CascadeType.ALL)
    private  PointOfSale pointOfSale;

    @Column(nullable = false)
    @OneToMany(mappedBy = "sportInventory",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<SportItemInfo> sportItemInfoList ;
    @Id
    private String nameOfItem; //САМОКАТ
}
