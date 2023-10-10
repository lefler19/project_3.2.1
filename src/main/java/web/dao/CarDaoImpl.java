package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class CarDaoImpl implements CarDao {

    private final List<Car> carList;
    {
        carList = new ArrayList<>();
        carList.add(new Car("Ford Focus", "white", 1_000_000));
        carList.add(new Car("Dodge RAM", "black", 4_000_000));
        carList.add(new Car("Lamborghini Urus", "yellow", 55_000_000));
        carList.add(new Car("Land Rover Range Rover Velar", "red", 6_000_000));
        carList.add(new Car("Ford Mustang", "blue", 3_000_000));
    }

    @Override
    public List<Car> getSomeCars(int count) {
        return IntStream.range(0, carList.size())
                .filter(l -> l < count)
                .mapToObj(carList::get)
                .toList();
    }
}
