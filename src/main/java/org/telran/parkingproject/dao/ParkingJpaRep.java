package org.telran.parkingproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telran.parkingproject.model.Car;
import org.telran.parkingproject.model.Parking;

import java.util.List;

public interface ParkingJpaRep extends JpaRepository<Parking, Integer> {

//    List<Car> findByParkingNum(int ParkingNum);

}
