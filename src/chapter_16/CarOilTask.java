package chapter_16;

public class CarOilTask {
    public static void main(String[] args) {

        Capacity c = new Capacity(50);
        Oil o = new Oil(50);
        OutGoing cr = new OutGoing(1,10);
        Car car = new Car(cr, c);
        Direction d = new Direction(5);

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

    public void setOil(int oil) {
        this.oil = oil;
    }
}

class OutGoing {
    private int road;
    private int range;

    public OutGoing( int range, int road ) {
        this.range = range;
        this.road = road;
    }

    public int getRange() {
        return range;
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


    public Car(OutGoing outGoing, Capacity capacity) {
        this.outGoing = outGoing;
        this.capacity = capacity;
        this.oils = new Oil(0);
    }


    boolean go(Direction direction) {
        int requid = direction.getDirectRange() * outGoing.getRange();
        if (oils.getOil() == 0) return false;
        if (oils.getOil() >= requid) {
            oils.setOil(oils.getOil() - requid);
            return true;
        }
        return false;
    }

    boolean addOil(Oil oil) {
        if (capacity.getCapacity() >= oil.getOil() + oils.getOil()) {
            oils.setOil(oils.getOil() + oil.getOil());
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
        return oils.getOil() / outGoing.getRange();
    }
}