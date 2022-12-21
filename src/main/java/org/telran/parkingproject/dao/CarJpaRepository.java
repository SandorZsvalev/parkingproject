package org.telran.parkingproject.dao;

import org.hibernate.annotations.SQLUpdate;
import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.telran.parkingproject.model.Car;

import java.util.List;
@Transactional
public interface CarJpaRepository extends JpaRepository<Car,Integer> {

 // раз уж разобрался и сделал, то удалять не буду - оставлю на память, вдруг понадобится.
 // получается, что добавлять на паркинг и убирать с паркинга можно в одну строчку из этого репозитория
 // хотя понятно, что это неверно архитектурно

 @Query(nativeQuery = true, value = "SELECT * FROM Car INNER JOIN Parking ON car.parking_num = :id")
 List <Car> findByParkingId(@Param("id") int id);

 @Modifying
 @Query(nativeQuery = true, value = "UPDATE Car SET car.parking_num = :parkingId where car.id = :carId")
 void addCarToParking (@Param("parkingId") int parkingId, @Param("carId") int carId);

}
