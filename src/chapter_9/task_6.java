package chapter_9;

public class task_6 {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3);

        Cat cat = new Cat("Whiskers", 2);

        Cow cow = new Cow("Bessie", 5);

        dog.getInfo();

        dog.makeSound();

        cat.getInfo();

        cat.makeSound();

        cow.getInfo();

        cow.makeSound();
    }
}

abstract class Animal {
    private String name;
    private int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    abstract public void makeSound();

    public void getInfo() {
        System.out.println("Name:"  + name);
        System.out.println("Age:"  + age);
        System.out.println();
    }
}

class Dog extends Animal{

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");

    }
}

class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

class Cow extends Animal {

    public Cow(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Mooo");
    }
}
