package ru.itis.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.model.Person;

import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegistrationDto {

    private String loginName;
    private String password;

    public Person getPerson(){
        return Person.builder().email(loginName).password(password).build();
    }

}
