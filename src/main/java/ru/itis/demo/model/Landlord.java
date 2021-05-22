package ru.itis.demo.model;


import com.sun.source.doctree.SerialDataTree;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Landlord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long landlordId;

    private String email;
    private String password;
    private String phone;
    @ToString.Exclude
    @OneToMany(mappedBy = "landlord",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PointOfSale> pointOfSales;

    @Enumerated(EnumType.STRING)
    private State state;
    public enum State{
        ACTIVE,BANNED
    }
}
