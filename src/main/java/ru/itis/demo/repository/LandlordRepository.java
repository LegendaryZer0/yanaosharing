package ru.itis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.demo.model.Landlord;

import java.util.List;

public interface LandlordRepository extends JpaRepository<Landlord,Long> {

    Landlord findLandlordByEmail(String email);

}
