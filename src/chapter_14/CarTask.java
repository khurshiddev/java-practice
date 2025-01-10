package chapter_14;

public class CarTask {
    public static void main(String[] args) {
        Car.getInstance("BMW",50);
        Car.getInstance("Porche",70);
        Car.getInstance("lacetti",50);
        System.out.println("Finish");
        System.out.println("car is active: " + Car.getInstance("BMW",50).isActice());
        System.out.println("add refual: " + Car.getInstance("BMW",50).refuel(30));
        System.out.println(Car.getInstance("BMW",50).getMaxWay(3));
    }
}

class Car {
    final String name;
    final int maxCapacity;
    int busyCapacity;

    private static Car instance;

    public Car(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    public static Car getInstance(String name, int maxCapacity) {
        if (instance == null) {
            instance = new Car(name, maxCapacity);
        }
        return instance;
    }

    public boolean isActice() {
        return busyCapacity > 0;
    }

    public boolean refuel(int addPetrol) {
        if(maxCapacity - busyCapacity < addPetrol) return false;
        busyCapacity += addPetrol;
        return true;
//        if (busyCapacity + addPetrol < maxCapacity) {
//            busyCapacity += addPetrol;
//            return true;
//        }
//        return false;
    }

    public int getMaxWay(int value) {
        return busyCapacity * value;
//        int refuelSumm = busyCapacity + value;
//        if(refuelSumm > maxCapacity){
//            refuelSumm = maxCapacity;
//        }
//        return refuelSumm * 12;

//        return perKm * 10;
    }

}