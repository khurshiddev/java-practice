package chapter_16;

public class CarOilTask {
    public static void main(String[] args) {

        Capacity c = new Capacity(45);
        Oil o = new Oil(45);
        OutGoing cr = new OutGoing(100, 5);
        Car car = new Car(cr, c);
        Direction d = new Direction(20);

        System.out.println("car go = " + car.go(d));
        System.out.println("car oil added = " + car.addOil(o));
        System.out.println("car go = " + car.go(d));
        System.out.println("car has oil = " + car.hasOil());
        System.out.println("car getMaxDirection = " + car.getMaxDirection());
        System.out.println("car is full = " + car.isFull());
    }
}

class Capacity {
    private int capacity;

    public Capacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

class Oil {
    int oil;

    public Oil(int oil) {
        this.oil = oil;
    }

    public int getOil() {
        return oil;
    }



//    public void setOil(int oil) {
//        this.oil = oil;
//    }
}

class OutGoing {
    private int road;
    private int range;

    public OutGoing(int road, int range) {
        this.road = road;
        this.range = range;
    }
}

class Direction {
    private int directRange;

    public Direction(int directRange) {
        this.directRange = directRange;
    }

    public int getDirectRange() {
        return directRange;
    }
}

class Car {
    private OutGoing outGoing;
    private Capacity capacity;
    private Oil oils;
    private Direction direction;


    public Car(OutGoing outGoing, Capacity capacity) {
        this.outGoing = outGoing;
        this.capacity = capacity;
        this.oils = new Oil(0);
    }


    boolean go(Direction direction) {
        this.direction = direction;
        if (oils.getOil() == 0) return false;
        int range = oils.getOil() * direction.getDirectRange();
        if (range > direction.getDirectRange()) {
            oils.oil -= direction.getDirectRange();
            return true;
        }
        return false;
    }

    boolean addOil(Oil oil) {
        if (capacity.getCapacity() >= oil.getOil() + oils.getOil()) {
            oils.oil += oil.oil;
            return true;
        }
        System.out.println("no empty space ");
        return false;
    }

    boolean isFull() {
        return oils.getOil() == capacity.getCapacity();
    }

    boolean hasOil() {
        return oils.getOil() > 0;
    }

    int getMaxDirection() {

        return oils.getOil() * direction.getDirectRange();
    }
}