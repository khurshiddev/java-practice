package chapter_20;

import java.util.*;

public class CarRentalTask {
    public static void main(String[] args) {
        CarRental rentalService = new CarRental("Avto Rent");

        Car car1 = new Car("Chevrolet Malibu", "AA1234BB");
        Car car2 = new Car("Hyundai Sonata", "CC5678DD");
        Car car3 = new Car("Toyota Corolla", "EE9101FF");

        checkTest(true, rentalService.addCar(car1));
        checkTest(true, rentalService.addCar(car2));
        checkTest(false, rentalService.addCar(car1));
        checkTest(false, rentalService.rentCar(car3, "Sherzod")); // Car not available
        checkTest(true, rentalService.rentCar(car1, "Sherzod")); // Renting successful
        checkTest(false, rentalService.rentCar(car1, "Aziz")); // Already rented
        checkTest(true, rentalService.isRented(car1)); // Car is rented
        checkTest(false, rentalService.isRented(car2)); // Car is not rented
        checkTest("Sherzod", rentalService.getRenter(car1)); // Check renter
        checkTest(true, rentalService.returnCar(car1)); // Return car
        checkTest(false, rentalService.returnCar(car1)); // Already returned
        checkTest(false, rentalService.isRented(car1)); // Not rented anymore
        checkTest(2, rentalService.getAvailableCars().size()); // 2 cars available
    }
    private static void checkTest(Object result, Object expected) {
        if (result == null || !result.equals(expected)) {
            throw new RuntimeException("Test failed: Expected " + expected + ", but got " + result);
        } else {
            System.out.println("Test passed: " + result);
        }
    }
}


class Car {
    private String model;
    private String number;

    public Car(String model, String number) {
        this.model = model;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, number);
    }
}

class CarRental {
    private String name;
    Map<Car, String> rentedCars;
    Set<Car> cars;

    public CarRental(String name) {
        this.name = name;
        rentedCars = new HashMap<>();
        cars = new HashSet<>();
    }

    boolean addCar(Car car) {
        return cars.add(car);
    }

    boolean rentCar(Car car, String customer) {
        if (!cars.contains(car) || rentedCars.containsKey(car)) {
            return false;
        }
        rentedCars.put(car, customer);
        return true;
    }

    boolean returnCar(Car car) {
        if (!rentedCars.containsKey(car)) {
            return false;
        }
        rentedCars.remove(car);
        return true;
    }

    boolean hasCar(Car car) {
        return cars.contains(car);
    }

    boolean isRented(Car car) {
        return rentedCars.containsKey(car);
    }

  Set<Car> getAvailableCars(){
        Set<Car> copy = new HashSet<>(cars);
        copy.removeAll(rentedCars.keySet());
        return copy;

  }

    String getRenter(Car car) {
        return rentedCars.getOrDefault(car, null);
    }
}