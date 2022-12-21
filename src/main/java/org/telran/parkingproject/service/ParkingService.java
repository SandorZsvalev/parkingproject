package org.telran.parkingproject.service;


import org.telran.parkingproject.model.Bike;
import org.telran.parkingproject.model.Car;
import org.telran.parkingproject.model.Parking;

import java.util.List;

public interface ParkingService {

        /*
    Получить список всех машин на парковке.
    Добавить машину на парковку
    Убрать машину с парковки.

    Основываться на проекте сделанном в классе, что бы можно было сначала добавить автомобиль через сервис авто,
    а потом этот автомобиль поставить или убрать с парковки.
     */

    List<Parking> list();

    Parking create (Parking parking);

    void addCarToParking(Car car, int parkingId);

    void addBikeToParking(Bike bike, int parkingId);

    void  deleteCarFromParking(Car car, int parkingId);

    void  deleteBikeFromParking(Bike bike, int parkingId);




}
