package chapter_15;

public class CarWithInnerClassTask {
    public static void main(String[] args) {
    Car car = new Car();
    Car.Engine engine = car.new Engine("BMW",250);
    car.showStateInfo();
    }
}

class Car {
    private String carModel;
    private int carSpeed;

    class Engine {
        private String carModel;
        private int carSpeed;

        public Engine(String carModel, int carSpeed) {
//            this.carModel = carModel;
//            this.carSpeed = carSpeed;
            Car.this.carModel = carModel;
            Car.this.carSpeed = carSpeed;
        }
    }

    void showStateInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", carSpeed=" + carSpeed +
                '}';
    }
}
