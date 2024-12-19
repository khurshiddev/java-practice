package chapter_8.task_2;

class IngredientFood {
    int size;
    String name;

    IngredientFood(String name, int size) {
        this.name = name;
        this.size = size;
    }

    int getSize() {
        return size;
    }

    String getName() {
        return name;
    }

    public void useQuantity(int amount) {
        if (amount <= size) {
            size -= amount;
        } else {
            throw new IllegalArgumentException("Not enough " + name);
        }
    }
}
