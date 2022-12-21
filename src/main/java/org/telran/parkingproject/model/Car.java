package org.telran.parkingproject.model;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Objects;

@Entity // говорим, что это сущность
@Table(name = "car") // куда мапить
public class Car {

    @Column(name = "name")
    private String name;
    @Column(name = "production_year")
    private int productionYear;
    @GeneratedValue(strategy = GenerationType.IDENTITY) //разные типы генерации id можно авто, можно по какой-то таблице
    @Id //показываем, что это id
    private int id;
    @Column(name = "color")
    private String color;

    public Car() {
        //
    }

    public Car(String name, int productionYear, String color) {
        this.name = name;
        this.productionYear = productionYear;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", productionYear=" + productionYear +
                ", id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
