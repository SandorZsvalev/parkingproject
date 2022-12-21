package org.telran.parkingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.parkingproject.model.Bike;
import org.telran.parkingproject.model.Car;
import org.telran.parkingproject.model.Parking;
import org.telran.parkingproject.service.BikeService;
import org.telran.parkingproject.service.CarService;
import org.telran.parkingproject.service.ParkingService;

import java.util.List;

@RestController
@RequestMapping ("/parking")
public class ParkingController {

    private static final int PARKING_NUMBER = 1;
    // делаю для работы с одним паркингом. Просто для удобства запросов

    @Autowired
    ParkingService parkingService;

    @Autowired
    CarService carService;

    @Autowired
    BikeService bikeService;

    @GetMapping
    public List<Parking> list(){
        return parkingService.list();
    }

    @PostMapping
    public Parking create (@RequestBody Parking parking){
        return parkingService.create(parking);
    }

    @PostMapping ("/car/{id}")
    public void addCarToParking (@PathVariable (name="id") int id){
        Car carToPark = carService.getById(id);
        parkingService.addCarToParking(carToPark,PARKING_NUMBER);
    }

    @PostMapping ("/bike/{id}")
    public void addBikeToParking (@PathVariable (name="id") int id){
        Bike bikeToPark = bikeService.getById(id);
        parkingService.addBikeToParking(bikeToPark, PARKING_NUMBER);
    }

    @DeleteMapping ("/car/{id}")
    public void deleteCarFromParking (@PathVariable (name="id") int id){
        Car carToDeleteFromPark = carService.getById(id);
        parkingService.deleteCarFromParking(carToDeleteFromPark, PARKING_NUMBER);
    }

    @DeleteMapping ("/bike/{id}")
    public void deleteBikeFromParking (@PathVariable (name="id") int id){
        Bike bikeToDeleteFromPark = bikeService.getById(id);
        parkingService.deleteBikeFromParking(bikeToDeleteFromPark, PARKING_NUMBER);
    }
}
