package ru.itis.demo.config.security.details;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.demo.model.Landlord;
import ru.itis.demo.model.Person;
import ru.itis.demo.repository.LandlordRepository;
import ru.itis.demo.repository.PersonRepository;

import java.util.Optional;

@Slf4j
@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepository usersRepository;

    @Autowired
    private LandlordRepository landlordRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Loading user with EMAIL " + email);
        Optional<Landlord> optionalLandlord = landlordRepository.findLandlordByEmail(email);
        if (optionalLandlord.isPresent()) {
            log.info("Landlord found");
            return new UserDetailsForLendLordImpl(optionalLandlord.get());
        }
        Person user = usersRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        log.info("Person found");
        return new UserDetailsImpl(user);
    }
}

