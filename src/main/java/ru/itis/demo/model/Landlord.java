package ru.itis.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
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

    @Column(unique = true)
    private String email;
    private String password;
    private String phone;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "landlord",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PointOfSale> pointOfSales = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private State state;
    public enum State{
        ACTIVE,BANNED
    }
}
