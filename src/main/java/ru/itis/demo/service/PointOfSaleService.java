package ru.itis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.model.Landlord;
import ru.itis.demo.model.PointOfSale;
import ru.itis.demo.repository.SalePointsRepository;

import java.util.List;

@Service
public class PointOfSaleService {
    @Autowired
    SalePointsRepository salePointsRepository;

    public void addTestSalePoint(){

    }
    public List<PointOfSale> findAll(){
        return salePointsRepository.findAll();
    }
}
