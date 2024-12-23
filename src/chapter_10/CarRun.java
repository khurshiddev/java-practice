package chapter_10;

public class CarRun {
    public static void main(String[] args) {
        Car car = new Car(2, 70);
        Battery battery1 = new Battery(1800);
        Battery battery2 = new Battery(2000);

        if (car.addBattery(battery1)) {
            checkTest(1, 1);
        } else {
            checkTest(0, 1);
        }
        if (car.addBattery(battery2)) {
            checkTest(1, 1);
        } else {
            checkTest(0, 1);
        }
        if (car.addBattery(new Battery(150))) {
            checkTest(1, 0);
        } else {
            checkTest(0, 0);
        }
        checkTest(car.getBatteryInfo(), 100);

        if (car.run(10)) {
            checkTest(1, 1);
        } else {
            checkTest(0, 1);
        }
        checkTest(car.getBatteryInfo(), 0);
    }


    private static int index = 0;

    private static void checkTest(Integer result, Integer expected) {
        if (result != expected && !expected.equals(result)) {
            throw new ArithmeticException("Natija xato");
        } else {
            System.out.println("✅ Test " + ++index);
        }
    }
}

class Battery {
    private int batterySize;
    private boolean isFull;

    public Battery(int batterySize) {
        this.batterySize = batterySize;
        this.isFull = true;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public boolean isFull() {
        return isFull;
    }

    public void discharge() {
        this.isFull = false;
    }
}

class Car {
    private int slots;
    private int power;
    private Battery[] battery;

    public Car(int battarey, int power) {
        this.slots = battarey;
        this.power = power;
        this.battery = new Battery[battarey]; // massiv ochdik
    }

    public boolean addBattery(Battery battery) {
        for (int i = 0; i < slots; i++) {
            if (this.battery[i] == null) { // Bo'sh joy topilsa
                this.battery[i] = battery;
                return true;
            }
        }
        return false;
    }

    public int getBatteryInfo() {
        int totalBattery = 0;
        for (Battery battery : battery) {
            if (battery != null && battery.isFull()) {
                totalBattery++;
            }
        }
        return (totalBattery * 100) / slots;
    }

    public boolean run(int minutes) {
        int capacity = 0;
        for (Battery battery : battery) {
            if (battery != null && battery.isFull()) {
                capacity += battery.getBatterySize();
            }
        }

        double current = capacity / 60.0;
        double power = current * 1.5;

        if (power >= this.power) {
            for (Battery battery : battery) {
                if (battery != null) {
                    battery.discharge();
                }
            }
            return true;
        }
        return false;
    }
}


