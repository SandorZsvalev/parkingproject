package org.telran.parkingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.parkingproject.model.Bike;
import org.telran.parkingproject.service.BikeService;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping
    public List<Bike> list (){
        return bikeService.list();
    }

    @PostMapping
    public Bike create(@RequestBody Bike bike){
        return bikeService.create(bike);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable (name="id") int id){
        bikeService.remove(id);
    }

    @GetMapping ("/{id}")
    public Bike getBike(@PathVariable (name="id") int id){
        return bikeService.getById(id);
    }

}
