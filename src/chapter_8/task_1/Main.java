package chapter_8.task_1;

public class Main {
    public static void main(String[] args) {
        Egg egg = new Egg("Egg", 2);
        Meat meat = new Meat("Meat", 1);
        Oil oil = new Oil("Oil", 1);
        Rise rise = new Rise("Rise", 3);
        Rise rise2 = new Rise("Rise", 1);

        Caldron caldron = new Caldron(5);
        caldron.add(egg);
        caldron.add(rise2);
        caldron.add(meat);
        caldron.add(oil);
        caldron.add(rise);
        caldron.showIngredient();
        System.out.println("Free space = " + caldron.getFreeSpace());
        System.out.println("Used space = " + caldron.getUsedSpace());
        System.out.println("Caldron is empty = " + caldron.isEmpty());
        System.out.println("Caldron is empty = "+caldron.isFull());

    }
}
