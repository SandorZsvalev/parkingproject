package org.telran.parkingproject.model;

import javax.persistence.*;

@Entity
@Table (name = "Bike")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // можно заменить на GenerationType.IDENTITY тогда не будет сквозной нумерации
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "years_production")
    private int yearsProduction;

    public Bike() {
        ///
    }

    public Bike(String name, int yearsProduction) {
        this.name = name;
        this.yearsProduction = yearsProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsProduction() {
        return yearsProduction;
    }

    public void setYearsProduction(int yearsProduction) {
        this.yearsProduction = yearsProduction;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearsProduction=" + yearsProduction +
                '}';
    }

}
