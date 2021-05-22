package ru.itis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.demo.model.Person;
import ru.itis.demo.model.dto.PersonForm;
import ru.itis.demo.model.dto.RegistrationDto;
import ru.itis.demo.repository.PersonRepository;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Person signUp(RegistrationDto registrationDto) {
        Optional<Person> optionalPerson = personRepository.findByEmail(registrationDto.getEmail());
        if (optionalPerson.isEmpty()) {
            throw new EntityExistsException("User is not exist");
        }

        Person person = Person.builder()
                .email(registrationDto.getEmail())
                .phone(registrationDto.getPhone())
                .name(registrationDto.getName())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .build();
        return personRepository.save(person);
    }

    @Override
    public void expel(Person person) {
        //удаление пользователя
    }
}
