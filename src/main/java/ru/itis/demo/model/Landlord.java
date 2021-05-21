package ru.itis.demo.model;


import lombok.*;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "landlord",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PointOfSale> pointOfSales;

    public enum State{
        ACTIVE,BANNED
    }
}
