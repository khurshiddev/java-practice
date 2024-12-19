package chapter_8;

public class Receipt {
    private String[] ingrNames;
    private int[] ingCount;
    private int size;

    public Receipt() {
        ingrNames = new String[20];
        ingCount = new int[20];
        size = 0;
    }

    public void addIngredients(String name, int count) {
        if (size >= ingrNames.length) {
            throw new IllegalStateException("Cannot add more ingredients.");
        }
        for (int i = 0; i < size; i++) {
            if (ingrNames[i].equals(name)) {
                ingCount[i] += count;
                return;
            }
        }
        ingrNames[size] = name;
        ingCount[size] = count;
        size++;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
       return size == ingrNames.length;
    }



    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(ingrNames[i] + ": " + ingCount[i] + " ");
        }
    }

    public String[] getIngrNames() {
        return ingrNames;
    }

    public int[] getIngCount(){
        return ingCount;
    }

    public int getSize(){
        return size;
    }
}
