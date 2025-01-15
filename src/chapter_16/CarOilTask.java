package chapter_16;

public class CarOilTask {
    public static void main(String[] args) {

        Capacity c = new Capacity(45);
        Oil o = new Oil(45);
        Outgoing cr = new Outgoing(100, 10);
        Car car = new Car(cr, c);
        Direction d = new Direction(23);

        System.out.println("car go = " + car.go(d));
        System.out.println("car has oil = " + car.hasOil());

        System.out.println("car oil added = " + car.addOil(o));
        System.out.println("car go = " + car.go(d));
        System.out.println("car has oil = " + car.hasOil());
        System.out.println("car getMaxDirection = " + car.getMaxDirection());
        System.out.println("car is full = " + car.isFullOil());


    }
}

class Capacity{
    public int capacity;
    Capacity(int capacity){
        this.capacity = capacity;

    }

    public int getCapacity() {
        return capacity;
    }
}
class Oil{
    public int totalOil;
    Oil(int oil){
        this.totalOil = oil;
    }

    public int getTotalOil() {
        return totalOil;
    }
}
class Outgoing{
    public int road;
    public int letr;
    Outgoing(int road, int letr){
        this.road=road;
        this.letr =letr;
    }

    public int getRoad() {
        return road;
    }

    public int getLetr() {
        return letr;
    }
}
class Direction{
    public int masofa;
    Direction(int masofa){
        this.masofa = masofa;

    }

    public int getMasofa() {
        return masofa;
    }
}
class Car{
    Outgoing outgoing;
    Capacity capacity;
    int oilSum;
    public Direction direction;
    Car(Outgoing outgoing, Capacity capacity){
        this.outgoing = outgoing;
        this.capacity = capacity;
        this.oilSum = 0;

    }

    public boolean go(Direction direction){
        this.direction = direction;
        if (oilSum ==0) return false;
        int range = oilSum * outgoing.getRoad();
        if (range/outgoing.getLetr() > direction.getMasofa()){
            oilSum -= (outgoing.letr *direction.getMasofa())/outgoing.getRoad();
            return true;
        }
        return false;

    }
    public boolean addOil(Oil oil){
        if(oilSum +oil.getTotalOil() <= capacity.getCapacity()){
            oilSum +=oil.getTotalOil();
            return true;
        }
        return false;
    }
    public boolean isFullOil(){
        return oilSum ==capacity.getCapacity();
    }
    public boolean hasOil(){
        return oilSum >0;
    }
    public int getMaxDirection(){
        return (oilSum *outgoing.getRoad())/ outgoing.getLetr();

    }
}

