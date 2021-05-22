package ru.itis.demo.service;

import ru.itis.demo.model.dto.PersonForm;
import ru.itis.demo.model.dto.RegistrationDto;
import ru.itis.demo.model.Person;
import ru.itis.demo.model.dto.RegistrationDto;

import java.util.Optional;

public interface SignUpService { //Todo Переименовать в signIn
    long signIn(PersonForm personForm);
    public Optional<Person> signUp(RegistrationDto registrationDto);

    void expel(Person person);

}
