package ru.itis.demo.model;


import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Landlord {
    @Id
    private Long landlordId;

    private String email;
    private String password;
    private String phone;
    @ToString.Exclude
    @OneToMany(mappedBy = "landlord",cascade = CascadeType.ALL)
    private List<PointOfSale> pointOfSales;

    public enum State{
        ACTIVE,BANNED
    }
}
