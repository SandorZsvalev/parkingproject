package org.telran.parkingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.parkingproject.dao.CarJpaRepository;
import org.telran.parkingproject.dao.ParkingJpaRep;
import org.telran.parkingproject.model.Bike;
import org.telran.parkingproject.model.Car;
import org.telran.parkingproject.model.Parking;

import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingJpaRep parkingJpaRep;

//    @Autowired
//    private CarJpaRepository carJpaRepository;


    @Override
    public List<Parking> list() {
        return parkingJpaRep.findAll();
    }

    @Override
    public Parking create(Parking parking) {
        return parkingJpaRep.save(parking);
    }

    // Здесь у меня есть вопрос, на который не знаю верного ответа:
    // в каждом методе я определяю паркинг, к которому обращаюсь, после этого беру оттуда нужный мне лист каров/байков
    // потом добавляю/удаляю транспорт и после этого заново сохраняю паркинг
    // это явно повторяющиеся фрагменты кода, но вынести не понимаю куда и как.

    // если выносить здесь же в private method, например List<Car> getCarsList то я не получаю внутри метода экземпляр
    // паркинга и не могу его сохранить после изменения в листе List<Car>.
    // Теоретически можно возвращать например не лист, а сет, где будет <Parking parking, List<Car> cars>,
    // но это выглядит еще более тяжеловесным и надуманным.
    // Разумным казалось бы создать внутри этого сервиса поле с нужным паркингом, но так не получается,
    // поскольку паркинги могут быть различными, а сервис создается один раз.
    // Почитал про рефакторинг и т.п., но не смог найти подходящего случая.

    // В общем, прошу здесь совета как правильно сделать.

    // При этом еще и системный вопрос - получается, что у меня нигде в самом коде приложения паркинг вообще не хранится
    // постоянно. То есть он читается из базы в методах, но за пределами этих методов его, очевидно, нигде нет. Это верный подход или
    // надо где-то создавать какой-то лист с паркингами, который будет доступен в разных объектах?


    // Реализовал чтение листа каров и добавление car по id на паркинг через carJpaRepository. Это здорово экономит
    // код и, кажется, его упрощает, но по сути, понимаю, что так делать неправильно. Из переписки в телеге получил
    // подтверждение сомнениям. Но оставил закомменченным, чтобы не забыть самому, как делал.


    // и ещё - в orElse  возвращаю null, что тоже, очевидно, не совсем правильно. Надо выбрасывать ислючение?
    // Я пробовал создавать новый паркинг тут, но это неверный путь, поскольку даёт новый паркинг,
    // хотя не найденный паркинг по id может быть просто ошибкой ввода, например.



    public void addCarToParking(Car car, int parkingId){

//        List <Car> cars = carJpaRepository.findByParkingId(parkingId); // получение списка car на паркинге напрямую
//        carJpaRepository.addCarToParking(parkingId, car.getId()); // прямое добавление car на паркинг

        Parking parking = parkingJpaRep.findById(parkingId).orElse(null); //прочитал весь паркинг из репозитория
        assert parking != null;
        List<Car> cars = parking.getCars(); //получил List car из паркинга
        if(!cars.contains(car)) {
            cars.add(car); // добавил car в лист, если его там еще нет
        } else {
            System.out.println("Car already on parking");
            return;
        }
        parkingJpaRep.save(parking); // сохранил паркинг заново
    }

    public void addBikeToParking(Bike bike, int parkingId){
        Parking parking = parkingJpaRep.findById(parkingId).orElse(null);
        assert parking != null;
        List<Bike> bikes = parking.getBikes();
        if(!bikes.contains(bike)){
        bikes.add(bike);}
        else {
            System.out.println("Bike already on parking");
            return;
        }
        parkingJpaRep.save(parking);
    }

    @Override
    public void deleteCarFromParking(Car car, int parkingId) {
        Parking parking = parkingJpaRep.findById(parkingId).orElse(null);
        assert parking != null;
        List<Car> cars = parking.getCars();
        cars.remove(car);
        parkingJpaRep.save(parking);
    }

    @Override
    public void deleteBikeFromParking(Bike bike, int parkingId) {
        Parking parking = parkingJpaRep.findById(parkingId).orElse(null);
        assert parking != null;
        List<Bike> bikes = parking.getBikes();
        bikes.remove(bike);
        parkingJpaRep.save(parking);
    }

}
