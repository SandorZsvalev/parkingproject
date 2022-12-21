package org.telran.parkingproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telran.parkingproject.model.Bike;

public interface BikeJpaRepository extends JpaRepository<Bike,Integer> {

}
