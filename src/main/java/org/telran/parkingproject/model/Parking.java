package org.telran.parkingproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "parking_num")
    private List<Bike> bikes = new ArrayList<>();
    // не добавляем в таблицу сразу
    // указываем по какой колонке мы связываем объекты - эта колонка появляется в байке (хотя ее нет в создании таблы)
    // в байке хранится id парковки на которой он находится

    @OneToMany
    @JoinColumn(name = "parking_num")
    private List<Car> cars = new ArrayList<>();

    public Parking() {
        //
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", bikes=" + bikes +
                ", cars=" + cars +
                '}';
    }
}
