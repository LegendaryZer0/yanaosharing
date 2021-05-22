package ru.itis.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.model.Person;
import ru.itis.demo.util.validation.AssertEquals;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@AssertEquals(
        fieldOne = "password",
        fieldTwo = "passwordRepeated")
public class RegistrationDto {


    @Size(min = 2, max = 30, message = "Choose name between 2 and 30 symbols")
    private String name;
    private String phone;
    @Size(min = 6, max = 30, message = "Choose password between 6 and 30 symbols")
    private String password;
    private String passwordRepeated;

    @NotBlank(message = "Enter your email")
    @Email(message = "Email is not correct")
    private String email;

    public Person build() {
        return Person.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .build();
    }
}
