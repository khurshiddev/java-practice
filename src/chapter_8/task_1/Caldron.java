package chapter_8.task_1;

public class Caldron {
    int caldronSize;
    int ingredients;
    int space;
    Ingredient[] ingredientArr;

    Caldron(int size) {
        this.caldronSize = size;
        this.space = size;
        ingredientArr = new Ingredient[size];

    }

    int getCaldronSize() {
        return caldronSize;
    }

    void add(Ingredient ingredient) {
        if (space < ingredient.getSize()) {
            System.out.println("Bosh joy yo'q");
            return;
        }
        System.out.println(ingredient.getName() + "  qo'shildi");

        System.out.println("----------------------------");
        ingredientArr[ingredients++] = ingredient;
        space -= ingredient.getSize();
    }


    boolean isEmpty() {
        return space == caldronSize;
    }

    boolean isFully() {
        if (caldronSize == space) {
            System.out.println("Caldronni joyi to'la");
            return true;
        }
        return false;
    }

    void showIngredients() {
        System.out.println("Hamma Maxsulotlar: ");
        for (int i = 0; i < ingredients; i++) {
            System.out.println("Name: " + ingredientArr[i].getName());
            System.out.println("Size: " + ingredientArr[i].getSize());
        }

    }

    int getUsedSpace() {
        return space - caldronSize;
    }

    int getFreeSpace() {
        return space;
    }


}


