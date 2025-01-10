package chapter_14;

public class FruitTask {
    public static void main(String[] args) {


        Basket basket = new Basket(15);

        Apple apple = new Apple("Apple", "Red", 5);
        Peach peach = new Peach("Peach", "Yellow", 6);
        Pomegranate pom = new Pomegranate("Pomegranate", "Red", 4);
//        Apple apple1 = new Apple("Apple", "Red", 5);

        basket.addFruit(apple);
//        basket.addFruit(apple1);
        basket.addFruit(peach);
        basket.addFruit(peach);
        basket.addFruit(pom);
        System.out.println("empty space: " + basket.getEmptySize() + " kg");
        System.out.println("basket is empty:  " + basket.isEmpty());
        System.out.println("basket is full:  " + basket.isFull());
        Fruit[] fruits = {apple, peach, pom};
        System.out.println("all fruits adding " + basket.addFruits(fruits));

    }
}

abstract class Fruit {
    private String name;
    private String color;
    private int weight;

    public Fruit(String name, String color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public final void showInfo() {
        System.out.println(this);

    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}

class Basket {
    private final int maxWeight;
    private int currentWeight;

    public Basket(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    public boolean isEmpty() {
        return currentWeight == 0;
    }

    public boolean isFull() {
        return currentWeight >= maxWeight;
    }
    public int getEmptySize() {
        return maxWeight - currentWeight;
    }

    private boolean addFruitMethod(Fruit fruit) {
        if (currentWeight + fruit.getWeight() <= maxWeight) {
            currentWeight += fruit.getWeight();
            System.out.println("added: " + fruit.getName());
            return true;
        } else {
            System.out.println("not empty space: " + fruit.getName());
            return false;
        }
    }

    public boolean addFruit(Apple apple) {
//        if (currentWeight + apple.weight <= maxWeight) {
//            currentWeight += apple.weight;
//            System.out.println("Fruit: " + apple.name + " added");
//            return true;
//        }
//        return false;
        return this.addFruitMethod(apple);
    }

    public boolean addFruit(Peach peach) {
//        if (currentWeight + peach.weight <= maxWeight) {
//            currentWeight += peach.weight;
//            System.out.println("Fruit: " + peach.name + " added");
//            return true;
//        }
//        return false;
        return this.addFruitMethod(peach);
    }

    public boolean addFruit(Pomegranate pomeg) {
//        if (currentWeight + pomeg.weight <= maxWeight) {
//            currentWeight += pomeg.weight;
//            System.out.println("Fruit: " + pomeg.name + " added");
//            return true;
//        }
//        return false;
        return this.addFruitMethod(pomeg);
    }




    public boolean addFruits(Fruit[] fruits) {
        for (Fruit fruit : fruits) {
          /*  if (currentWeight + fruit.weight < maxWeight) {
                currentWeight += fruit.weight;
                System.out.println("Fruit added");
                return true;
            }*/
            if (!addFruitMethod(fruit)) {
                return false;
            }
        }
        return false;
    }
}


class Apple extends Fruit {
    public Apple(String name, String color, int weight) {
        super("Apple", color, weight);
    }
}

class Peach extends Fruit {

    public Peach(String name, String color, int weight) {
        super("Peach", color, weight);
    }
}

class Pomegranate extends Fruit {

    public Pomegranate(String name, String color, int weight) {
        super("Pomegranate", color, weight);
    }

}
