package ru.koshelev.personalapp.dao;

import org.springframework.stereotype.Component;
import ru.koshelev.personalapp.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao {
    private static int countCar;

    @Override
    public String toString() {
        return "CarDao{" +
                "cars=" + cars +
                '}';
    }

    private List<Car> cars;
    {
        cars=new ArrayList<Car>();
        cars.add(new Car(++countCar,"Mercedes","s500",5800, 2013));
        cars.add(new Car(++countCar,"BMW","535",4300, 2012));
        cars.add(new Car(++countCar,"Honda","Accord",3450, 2011));
        cars.add(new Car(++countCar,"Honda","Civic",2000, 2010));
    }

    public List<Car> carList(){
        return cars;
    }

    public Car showCar(int id){
        return cars.stream().filter(car->car.getId()==id).findAny().orElse(null);
    }

    public void createCar(Car car){
        car.setId(++countCar);
        cars.add(car);
        System.out.println(cars);
    }

    public void delete(int id){
        cars.removeIf(car -> car.getId()==id);
    }

    public void update(int id,Car updatedCar){
        Car carToUpdate=showCar(id);
        int i = cars.indexOf(carToUpdate);
        cars.set(i,updatedCar);
    }
}
