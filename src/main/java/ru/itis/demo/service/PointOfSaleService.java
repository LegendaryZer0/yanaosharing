package ru.itis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.model.Landlord;
import ru.itis.demo.model.PointOfSale;
import ru.itis.demo.repository.SalePointsRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class PointOfSaleService {
    @Autowired
    SalePointsRepository salePointsRepository;

    @Autowired
    EntityManager entityManager;
    @Transactional
    public void addTestSalePoint(PointOfSale point){

      salePointsRepository.save(point);


    }

    @Transactional
    public void updateSalePointById(PointOfSale salePoint){

       PointOfSale point =salePointsRepository.findById(salePoint.getPointOfSaleId()).orElseThrow(EntityNotFoundException::new);
       point.setDescription(salePoint.getDescription());
       point.setLandlord(salePoint.getLandlord());
       point.setNameOfOrganization(salePoint.getNameOfOrganization());
       point.setPositionX(salePoint.getPositionX());
       point.setPositionY(salePoint.getPositionY());
       point.setSportInventoryList(salePoint.getSportInventoryList());
       salePointsRepository.save(salePoint);

    }
    public List<PointOfSale> findAll(){
        return salePointsRepository.findAll();
    }
}
