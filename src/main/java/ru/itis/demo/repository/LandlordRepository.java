package ru.itis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.model.Landlord;

public interface LandlordRepository extends JpaRepository<Landlord,Long> {
}
