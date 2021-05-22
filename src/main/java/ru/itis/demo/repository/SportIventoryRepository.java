package ru.itis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.model.SportInventory;

import java.util.List;

public interface SportIventoryRepository extends JpaRepository<SportInventory,Long> {


}
