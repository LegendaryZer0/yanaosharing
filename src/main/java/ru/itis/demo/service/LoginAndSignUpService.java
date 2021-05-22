package ru.itis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.model.Person;
import ru.itis.demo.model.dto.PersonForm;
import ru.itis.demo.model.dto.RegistrationDto;
import ru.itis.demo.repository.PersonRepository;

import java.util.Optional;

@Service
public class LoginAndSignUpService implements SignUpService{
    @Autowired
    private PersonRepository personRepository;
    @Override
    public long signIn(PersonForm personForm) {
        return 0;
    }

    @Override
    public void expel(Person person) {

    }
    public Optional<Person> signUp(RegistrationDto registrationDto){

        if(personRepository.findByEmail(registrationDto.getEmail()).isPresent()){
            return Optional.empty();
        }else {
            return Optional.of(personRepository.save(registrationDto.build()));
        }


    }
}
