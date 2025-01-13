package chapter_15;

public class AnonymousInnerClassTask {
    public static void main(String[] args) {

        Shape rectangle = new Shape() {
            @Override
            public double draw(double width, double length) {
                return width * length;
            }
        };
        Shape circle = new Shape() {
            @Override
            public double draw(double width, double length) {
                return Math.PI * width * width;
            }
        };

        Shape triangle = new Shape() {
            @Override
            public double draw(double width, double length) {
                double base = width;
                double height = length;
                return height * base / 2;
            }
        };

        System.out.println("ractangle is: " + rectangle.draw(2, 5));
        System.out.println("circle is: " + circle.draw(2, 5));
        System.out.println("triangle is: " + triangle.draw(2, 5));

    }
}

interface Shape {
    double draw(double width, double length);

}



