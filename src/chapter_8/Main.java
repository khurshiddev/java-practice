package chapter_8;

public class Main {
    public static void main(String[] args) {

        Receipt receipt = new Receipt();
        receipt.addIngredients("Flour", 2);
        receipt.addIngredients("Oil", 1);


        System.out.println("Receipt:");
        receipt.show();
        System.out.println("ichi to'lami? " + receipt.isFull());
        Food food = new Food(receipt);
        food.add(new IngredientFood("Flour", 5));
        food.add(new IngredientFood("Oil", 2));

        System.out.println("Ovqat tayyorlasa bo'ladimi? " + food.getCount());
        System.out.println("Has food? " + food.hasFood());

        food.getReceipt();

    }
}
