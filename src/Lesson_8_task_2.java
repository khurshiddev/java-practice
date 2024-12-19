public class Lesson_8_task_2 {
    public static class Main {
        public static void main(String[] args) {

            Meat meat = new Meat(5);
            Oil oil = new Oil(2);
            Onion onion = new Onion(2);
            Salt salt = new Salt(10);
            Egg egg = new Egg(3);

            Caldron caldron = new Caldron(20);
            caldron.add(meat);
            caldron.add(oil);
            caldron.add(onion);
            caldron.add(salt);
            caldron.add(egg);
            caldron.showIngredients();

        }
    }

    public static class Caldron {
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

    abstract static class Ingredient {
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

    public static class Egg extends Ingredient {

        Egg(int eggCount) {
            super("Egg", eggCount);
        }
    }

    static class Meat extends Ingredient {

        Meat(int meatSize) {
            super("Meat", meatSize);
        }


    }

    public static class Oil extends Ingredient {

        Oil(int oilSize) {
            super("Oil", oilSize);
        }

    }

    public static class Onion extends Ingredient {

        Onion(int oinonCount) {
            super("Onion", oinonCount);
        }


    }

    public static class Salt extends Ingredient {

        Salt(int saltGram) {
            super("Salt", saltGram);
        }
    }
}
