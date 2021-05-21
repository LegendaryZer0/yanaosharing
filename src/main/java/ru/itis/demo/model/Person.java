package ru.itis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @Id
    private Long id;
    private String  name;
    private String phone;
    private String password;
    private String email;

    private Role role;
    private State state;
    public  enum Role{
        USER,ADMIN
    }
    public enum State{
        ACTIVE,BANNED
    }
}
