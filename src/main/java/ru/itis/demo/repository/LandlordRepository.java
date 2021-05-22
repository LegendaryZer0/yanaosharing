package ru.itis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.demo.model.Landlord;

import java.util.List;
import java.util.Optional;

public interface LandlordRepository extends JpaRepository<Landlord,Long> {

    Optional<Landlord> findLandlordByEmail(String email);

}
