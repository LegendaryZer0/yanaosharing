package ru.itis.demo.service;

import ru.itis.demo.model.Landlord;
import ru.itis.demo.model.dto.PersonForm;
import ru.itis.demo.model.dto.RegistrationDto;
import ru.itis.demo.model.Person;
import ru.itis.demo.model.dto.RegistrationDto;

import java.util.Optional;

public interface SignUpService {
    Person signUp(RegistrationDto registrationDto);
    Landlord signUpAsLandlord(RegistrationDto registrationDto);
    void expel(Person person);
}
