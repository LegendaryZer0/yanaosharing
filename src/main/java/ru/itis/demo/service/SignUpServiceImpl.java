package ru.itis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.demo.model.Landlord;
import ru.itis.demo.model.Person;
import ru.itis.demo.model.dto.PersonForm;
import ru.itis.demo.model.dto.RegistrationDto;
import ru.itis.demo.repository.LandlordRepository;
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
        if (optionalPerson.isPresent()) {
            throw new EntityExistsException("User is already exist");
        }

        Person person = Person.builder()
                .email(registrationDto.getEmail())
                .phone(registrationDto.getPhone())
                .name(registrationDto.getName())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .build();
        return personRepository.save(person);
    }

    @Autowired
    private LandlordRepository landlordRepository;

    @Override
    public Landlord signUpAsLandlord(RegistrationDto registrationDto) {
        Optional<Landlord> optionalPerson = landlordRepository.findLandlordByEmail(registrationDto.getEmail());
        if (optionalPerson.isPresent()) {
            throw new EntityExistsException("User is already exist");
        }

        Landlord person = Landlord.builder()
                .name(registrationDto.getName())
                .email(registrationDto.getEmail())
                .phone(registrationDto.getPhone())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .build();
        return landlordRepository.save(person);
    }

    @Override
    public void expel(Person person) {
        //удаление пользователя
    }
}
