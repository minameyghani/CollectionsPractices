package practice2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("pride", "white", 120));
        cars.add(new Car("206", "black", 130));
        cars.add(new Car("BMW", "black", 220));
        cars.add(new Car("pride","black",120));
        System.out.println(cars.toString());
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            for (Car c : cars) {
                if (c.equals(car)) {
                    System.out.println("there is quality between element" + c.toString() + "and " +
                            car.toString() + " in Set");
                } else {
                    System.out.println("there is not quality between element " + c.toString() + " and "
                            + car.toString() + " in Set");
                }

            }
        }
    }
}
