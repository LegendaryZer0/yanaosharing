package ru.itis.demo.service;

import org.springframework.stereotype.Service;
import ru.itis.demo.model.Person;
import ru.itis.demo.model.dto.PersonForm;
@Service
public class SignUpServiceImpl implements SignUpService{
    @Override
    public long signUp(PersonForm personForm) {
        return 0;
    }

    @Override
    public void expel(Person person) {

    }
}
