package ru.itis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.model.PointOfSale;
import ru.itis.demo.model.SportInventory;
import ru.itis.demo.repository.SalePointsRepository;
import ru.itis.demo.repository.SportIventoryRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private SportIventoryRepository sportIventoryRepository;
    @Autowired
    private SalePointsRepository salePointsRepository;
    public void searchForCriteria(){

    }
    public Set<String> findAllNameOfItems(){
        return sportIventoryRepository.findAll().stream().map(SportInventory::getNameOfItem).collect(Collectors.toSet());
    }

    public Optional<PointOfSale> getPointOfSale(Long id){
        return salePointsRepository.findById(id);
    }
}
