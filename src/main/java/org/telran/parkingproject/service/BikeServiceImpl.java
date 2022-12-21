package org.telran.parkingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.parkingproject.dao.BikeJpaRepository;
import org.telran.parkingproject.model.Bike;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeJpaRepository bikeJpaRepository;

    @Override
    public List<Bike> list() {
        return bikeJpaRepository.findAll();
    }

    @Override
    public Bike create(Bike bike) {
        return bikeJpaRepository.save(bike);
    }

    @Override
    public void remove(int id) {
        Bike bike = bikeJpaRepository.findById(id).orElse(null);
        if (bike != null) {
            bikeJpaRepository.delete(bike);
        } else {
            System.out.println("not found");
        }
    }

    @Override
    public Bike getById(int id) {
        Bike bike = bikeJpaRepository.findById(id).orElse(null);
        if (bike != null) {
            return bike;
        } else {
            System.out.println("not found");
            return null;
        }
    }
}
