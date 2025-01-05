package chapter_8.task_1;

public class Caldron {
    private int size;
    private int count;
    Ingredients[] ingredients;

    public Caldron(int size) {
        this.size = size;
        this.ingredients = new Ingredients[size];
        this.count = 0;
    }

    private int indexOf(String name) {
        for (int i = 0; i < count; i++) {
            Ingredients ing = ingredients[i];
            if (ing.name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void add(Ingredients ingred){
        int check = indexOf(ingred.name);
        if(check != -1) {
            ingredients[check].count += ingred.count;
        } else if (size >= count) {
            ingredients[count++] = ingred;
        }else {
            System.out.println("Caldros is full");
        }
    }

    public void showIngredient() {
        for (int i = 0; i < count; i++) {
            System.out.println("name = " + ingredients[i].name);
            System.out.println("count = " + ingredients[i].count);
        }
    }

    public boolean isFull() {
        return count == size;
    }
    public boolean isEmpty() {
        return count == 0;
    }

    public int getFreeSpace(){
        return size - count;
    }
    public int getUsedSpace(){
        return count;
    }
}




