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
public class PointOfSale {
    @Id
    private Long pointOfSaleId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Landlord landlord;

    @OneToMany(mappedBy = "pointOfSale")
    private List<SportInventory> sportInventoryList;

    private String nameOfOrganization;

    private Double positionX;
    private Double positionY;


}
