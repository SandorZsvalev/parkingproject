package org.telran.parkingproject.service;

import org.telran.parkingproject.model.Bike;

import java.util.List;

public interface BikeService {

    List<Bike> list();

    Bike create(Bike bike);

    void remove (int id);

    Bike getById(int id);

}
