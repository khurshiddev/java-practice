package chapter_5;

public class AnimalHierarchy {
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
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void makeSound();

    abstract void getInfo();

}

class Dog extends Animal {
    String name;
    int age;

    public Dog(String name, int age) {
        super(name, age);
        this.age = age;
        this.name = name;
    }

    @Override
    void makeSound() {
        System.out.println("Woof");
    }

    @Override
    void getInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Cat extends Animal {
    String name;
    int age;

    public Cat(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    @Override
    void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    void getInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Cow extends Animal {
    String name;
    int age;

    public Cow(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    @Override
    void makeSound() {
        System.out.println("Moo!");
    }

    @Override
    void getInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Cow{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}