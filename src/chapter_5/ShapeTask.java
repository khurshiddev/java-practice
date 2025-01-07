package chapter_5;

public class ShapeTask {
    public static void main(String[] args) {
        Shape shape = new Shape("House","Green","10","20");
        shape.show();
        shape.showPerimeter();
    }
}
class Shape {
    String name;
    String color;
    String perimeter;
    String square;

    public Shape(String name, String color, String perimeter, String square) {
        this.name = name;
        this.color = color;
        this.perimeter = perimeter;
        this.square = square;
    }

    public void show(){
        System.out.println(this);
    }

    public void showPerimeter() {
        System.out.println("-----");
        System.out.println("perimeter is = " + perimeter);
    }
    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", perimeter='" + perimeter + '\'' +
                ", square='" + square + '\'' +
                '}';
    }
}
