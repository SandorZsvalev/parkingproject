package org.telran.parkingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.parkingproject.dao.CarJpaRepository;
import org.telran.parkingproject.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarJpaRepository carJpaRepository;

    @Override
    public List<Car> list() {
        return carJpaRepository.findAll();
    }

    @Override
    public Car create(Car car) {
        return carJpaRepository.save(car);
    }

    @Override
    public void remove(int id) {
        Car car = carJpaRepository.findById(id).orElse(null);
        if (car!=null) {
            carJpaRepository.delete(car);
        } else {
            System.out.println("not found");;
        }
    }

    @Override
    public Car getById(int id) {
        return carJpaRepository.findById(id).orElse(null);
    }

    @Override
    public Car update(Car car) {
        return null;
    }

}