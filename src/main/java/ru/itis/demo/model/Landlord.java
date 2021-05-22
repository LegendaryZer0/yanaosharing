package ru.itis.demo.model;


import com.sun.source.doctree.SerialDataTree;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
    private Set<PointOfSale> pointOfSales;

    public enum State{
        ACTIVE,BANNED
    }
}
