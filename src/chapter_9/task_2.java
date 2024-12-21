package chapter_9;

public class task_2 {
    public static void main(String[] args) {
        Uchburchak uch = new Uchburchak(12, 7, 5, 9);
        System.out.println(uch.perimetr());
        System.out.println(uch.hisoblash());

        Doira doira = new Doira(20);
        System.out.println(doira.hisoblash());
        System.out.println(doira.perimetr());

        Tortburchak tort = new Tortburchak(18, 20, 20,10);
        System.out.println(tort.hisoblash());
        System.out.println(tort.perimetr());
    }
}

abstract class Shakl {
    abstract public double hisoblash();

    abstract public double perimetr();

}

class Uchburchak extends Shakl {
    private double base;
    private double height;
    private double aSide;
    private double bSide;

    public Uchburchak(double base, double height, double aSide, double bSide) {
        this.base = base;
        this.height = height;
        this.aSide = aSide;
        this.bSide = bSide;
    }

    @Override
    public double hisoblash() {
        return height * base / 2;
    }

    @Override
    public double perimetr() {
        return base + aSide + bSide;
    }
}

class Doira extends Shakl {
    private double radius;

    public Doira(double radius) {
        this.radius = radius;
    }

    @Override
    public double hisoblash() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimetr() {
        return 2 * Math.PI * radius;
    }
}

class Tortburchak extends Shakl {

    private int length;
    private int width;
    private int are;
    private int perimetr;

    public Tortburchak(int length, int width, int are, int perimetr) {
        this.length = length;
        this.width = width;
        this.are = are;
        this.perimetr = perimetr;
    }

    @Override
    public double hisoblash() {
        return are = width * length;
    }

    @Override
    public double perimetr() {
        return perimetr = 2*(width + length);
    }
}
