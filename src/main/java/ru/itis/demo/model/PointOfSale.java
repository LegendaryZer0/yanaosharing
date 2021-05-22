package ru.itis.demo.model;

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
public class PointOfSale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointOfSaleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Landlord landlord;

    @OneToMany(mappedBy = "pointOfSale",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<SportInventory> sportInventoryList = new ArrayList<>();
    @Column(nullable = false)
    private String nameOfOrganization;
    @Column(nullable = false)
    private Double positionX;
    @Column(nullable = false)
    private Double positionY;


}
