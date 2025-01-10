package chapter_14;

public class ShapeTask {
    public static void main(String[] args) {

    }
}



interface  Shape {
     double parameter();
     double square();
}

class Rectangles implements Shape {
    private double width;
    private double height;
    private double p;
    private double s;

    public Rectangles(double width, double height) {
        this.width = width;
        this.height = height;
        p = 2 * (width + height);
        s = width * height;
    }

    @Override
    public double parameter() {
        return p;
    }

    @Override
    public double square() {
        return s;
    }
}

class Circle implements Shape {
    private double radius;
    private double p;
    private double s;

    public Circle(double radius) {
        this.radius = radius;
        p = s * Math.PI * radius;
        s = Math.PI * radius * radius;
    }

    @Override
    public double parameter() {
        return p;
    }

    @Override
    public double square() {
        return s;
    }
}

class Triangle implements Shape {
    private int a;
    private int b;
    private int c;
    private double p;
    private double s;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        p = a + b + c;
        s = Math.sqrt((p / 2) * (p / 2 - a) * (p / 2 - b) * (p / 2 - c));
    }

    @Override
    public double parameter() {
        return p;
    }

    @Override
    public double square() {
        return s;
    }
}