package chapter_9;

public class task_7 {
    public static void main(String[] args) {

        Circle cir = new Circle("Red", 5);
        Rectangle rec = new Rectangle("Blue", 4, 6);
        Triangle tri = new Triangle("Green", 3, 4, 3, 5);


        System.out.println("Circle ");
        System.out.println("Color = " + cir.getColor());
        System.out.println("Area = " + cir.calculateArea());
        System.out.println("Perimeter = " + cir.calculatePerimeter());
        System.out.println("-----------------------");
        System.out.println("Rectangle: ");
        System.out.println("Color = " + rec.getColor());
        System.out.println("Area = " + rec.calculateArea());
        System.out.println("Perimeter = " + rec.calculatePerimeter());
        System.out.println("-----------------------");
        System.out.println("Triangle: ");
        System.out.println("Color = " + tri.getColor());
        System.out.println("Area = " + tri.calculateArea());
        System.out.println("Perimeter = " + tri.calculatePerimeter());
    }
}

abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();


    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}


class Triangle extends Shape {
    private double base, height, sideA, sideB;

    public Triangle(String color, double base, double height, double sideA, double sideB) {
        super(color);
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return base + sideA + sideB; // Perimeter of triangle: base + sideA + sideB
    }
}
