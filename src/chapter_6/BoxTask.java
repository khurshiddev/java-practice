package chapter_6;

public class BoxTask {
    public static void main(String[] args) {
        Things things = new Things("Sprite", 2);
        Box box = new Box(2);
        System.out.println(box.push(things));
        System.out.println(box.isFull());
    }
}

class Box {
    int boxSize;
    int temp;


    public Box(int boxSize) {
        this.boxSize = boxSize;
    }

    public boolean push(Things things) {
        if (things.size <= boxSize) {
            temp += things.size;
            return true;
        }
        System.out.println("Box is full");
        return false;
    }

    public boolean isFull() {
        return temp == boxSize;
    }
}

class Things {
    String name;
    int size;

    public Things(String name, int size) {
        this.name = name;
        this.size = size;
    }
}