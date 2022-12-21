package org.telran.parkingproject.service;

import org.telran.parkingproject.model.Car;

import java.util.List;

public interface CarService {

     List<Car> list();

     Car create(Car car); //создание сущности должен возвращать новую сущность (car он получает от контроллера через json) после сохр в базу

    void remove(int id);

    Car getById(int id);

    Car update(Car car);

}
