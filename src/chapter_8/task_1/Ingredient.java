package chapter_8.task_1;

abstract class Ingredient {
    String name;
    int size;

    Ingredient(String name, int size) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}


