package ru.itis.demo.service;

import ru.itis.demo.model.dto.PersonForm;
import ru.itis.demo.model.Person;
import ru.itis.demo.model.dto.RegistrationDto;

import java.util.Optional;

public interface SignUpService { //Todo Переименовать в signIn
    int NAME_SIZE_ERROR = -8;
    int UNKNOWN_ERROR = -7;
    int EMPTY_FIELD = -6;
    int AGREEMENT_FALSE = -5;
    int PWDS_NOT_EQUALS = -4;
    int PWD_SIZE_LONG = -3;
    int PWD_SIZE_SHORT = -2;
    int EMAIL_INCORRECT = -1;
    int ALREADY_EXIST = 0;
    int SUCCESS = 1;
    int REGISTERED_WITH_ERROR = 2;
    long signIn(PersonForm personForm);
    public Optional<Person> signUp(RegistrationDto registrationDto);

    void expel(Person person);

}
