package chapter_14;

import java.util.Arrays;

public class IceCreamTask {
    public static void main(String[] args) {
        Milk m = new Milk(80, 2000);//litr, 1L narxi
        Sugar s = new Sugar(120, 6000);//kg, narxi
        Recep r = new Recep(2, 1);//sut, shakar
        Piece f = new Piece(0.2, 2000);//kg, narxi
        IceCream ic = new IceCream(f,r);
        ic.addMilk(m);
        ic.addSugar(s);
        ic.getCount();
        ic.buy(5);//boolean
        ic.getBalance(); //int
        ic.hasIceCream();//boolean
        ic.getInfo();
        ic.getProfit();//Hozirgacha ko'rgan foydasi

    }
}

class IceCream {
    private Piece piece;
    private Recep recep;
    private double buyBalance;
    private double sellBalance;
    private double sugarCapacity;
    private double milkCapacity;
    private int[] list;
    private int index;
    private int len = 10;
    private double milkPercentage;
    private double sugarPercentage;

    public IceCream(Piece piece, Recep recep) {
        this.piece = piece;
        this.recep = recep;
        this.list = new int[len];
        //percentage 1 bop'lakni qiymati

    }

    public void addMilk(Milk milk) {
        milkCapacity += milk.getCapacity();
        buyBalance += milk.getCapacity() * milk.getCapacity();
    }

    public void addSugar(Sugar sugar) {
        sugarCapacity += sugar.getCapacity();
        buyBalance += sugar.getCapacity() * sugar.getCapacity();
    }

    public int getCount() {
        // percentage 1 bo'lak
        int percentage = (int) piece.getIceCreamCapacity() / (recep.getMilkPercentage() + recep.getSugarPercentage());
        sugarPercentage = percentage * recep.getSugarPercentage();
        milkPercentage = percentage * recep.getMilkPercentage();
        return (int) Math.min(sugarCapacity / sugarPercentage, milkCapacity / milkPercentage);
    }

    public boolean buy(int count) {
        if (getCount() < count) return false;
        if (index == len) {
            len += len >> 1;
            list = Arrays.copyOf(list, len);
        }
        sellBalance += count * piece.getPrice();
        list[index++] = count;
        sugarCapacity -= sugarPercentage * count;
        milkCapacity -= milkPercentage * count;
        return true;
    }

    public double getBalance() {
        return sellBalance;
    }

    public boolean hasIceCream() {
        return getCount() > 0;
    }

    public void getInfo() {
        if (index == 0) {
            System.out.println(" ");
            return;
        }
        for (int i = 0; i < index; i++) {
            System.out.println(list[i] + "x" +
                    piece.getPrice() + "=" + (list[i] * piece.getPrice()));
        }
    }

    public double getProfit() {
        return sellBalance - buyBalance;
    }
}

class Piece {
    private double iceCreamCapacity;

    public Piece(double iceCreamCapacity, int price) {
        this.iceCreamCapacity = iceCreamCapacity;
        this.price = price;
    }

    private int price;

    public double getIceCreamCapacity() {
        return iceCreamCapacity;
    }

    public int getPrice() {
        return price;
    }
}

class Recep {
    private int milkPercentage;
    private int sugarPercentage;

    public Recep(int milkPercentage, int sugarPercentage) {
        this.milkPercentage = milkPercentage;
        this.sugarPercentage = sugarPercentage;
    }

    public int getMilkPercentage() {
        return milkPercentage;
    }

    public int getSugarPercentage() {
        return sugarPercentage;
    }


}

class Milk {
    private int capacity;

    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    private int price;

    public Milk(int capacity, int price) {
        this.capacity = capacity;
        this.price = price;
    }
}

class Sugar {
    private int capacity;
    private int price;

    public Sugar(int capacity, int price) {
        this.capacity = capacity;
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }
}
