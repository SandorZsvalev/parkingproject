package org.telran.parkingproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.parkingproject.model.Car;
import org.telran.parkingproject.service.CarService;

import java.util.List;

@RestController
@RequestMapping ("/cars") //localhost:8080/cars
public class CarController {

    @Autowired
    private CarService carService;

    //localhost:8080/cars
    @GetMapping
    public List<Car> list(){
        return carService.list();
    }

    //localhost:8080/cars/id
    @GetMapping ("/{id}")
    public Car getCar (@PathVariable(name = "id") int id){
        return carService.getById(id);
    }

    //localhost:8080/cars только с методом пост
    @PostMapping
    public Car create(@RequestBody Car car){
        return carService.create(car);
    }


    //localhost:8080/cars
    @DeleteMapping ("/{id}")
    public void remove(@PathVariable (name = "id") int id){
         carService.remove(id);
    }

}
