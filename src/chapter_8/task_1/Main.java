package chapter_8.task_1;

public class Main {
    public static void main(String[] args) {
        Meat meat = new Meat(5);
        Oil oil = new Oil(2);
        Onion onion = new Onion(2);
        Salt salt = new Salt(10);
        Egg egg = new Egg(5);

        Caldron caldron = new Caldron(20);
        caldron.add(meat);
        caldron.add(oil);
        caldron.add(onion);
        caldron.add(salt);
        caldron.add(egg);
        caldron.showIngredients();
    }

}
