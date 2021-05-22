package ru.itis.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PointOfSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointOfSaleId;

    @JoinColumn(name = "landlord")
    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Landlord landlord;

    @OneToMany(mappedBy = "pointOfSale",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<SportInventory> sportInventoryList;
    @Column(nullable = false)
    private String nameOfOrganization;
    @Column(nullable = false)
    private Double positionX;
    @Column(nullable = false)
    private Double positionY;


}
