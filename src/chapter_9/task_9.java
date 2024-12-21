package chapter_9;

public class task_9 {
        public static void main(String[] args) {

            Car car = new Car("Cobalt", 2023, 4);
            Bike bike = new Bike("Suzuki", 2022, 1);
            Bus bus = new Bus("Isuzi", 2021, 50);
            System.out.println("Car");
            System.out.println(car.getVehicleInfo());
            System.out.println("car = " + car.drive());
            System.out.println("----------");
            System.out.println("Bike");
            System.out.println(bike.getVehicleInfo());
            System.out.println("Bike = " + bike.drive());
            System.out.println("----------");
            System.out.println("Bus");
            System.out.println(bus.getVehicleInfo());
            System.out.println("Bus = " + bus.drive() );
        }
    }


    abstract class Vehicle {
        private String make;
        private int model;

        public Vehicle(String make, int model) {
            this.make = make;
            this.model = model;
        }

        public abstract double drive();

        public String getVehicleInfo() {
            return "Make: " + make + ", Model: " + model;
        }
    }


    class Car extends Vehicle {
        private double doors;

        public Car(String make, int model, double doors) {
            super(make, model);
            this.doors = doors;
        }

        @Override
        public double drive() {
            return 200.0;
        }
    }


    class Bike extends Vehicle {
        private double type;

        public Bike(String make, int model, double type) {
            super(make, model);
            this.type = type;
        }

        @Override
        public double drive() {
            return 50.0;
        }
    }


    class Bus extends Vehicle {
        private double capacity;

        public Bus(String make, int model, double capacity) {
            super(make, model);
            this.capacity = capacity;
        }

        @Override
        public double drive() {
            return 100.0;
        }
    }


