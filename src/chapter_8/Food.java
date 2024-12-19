package chapter_8;

public class Food {
    private Receipt receipt;
    private IngredientFood[] foodArr;
    private int foodSize;

    public Food(Receipt receipt){
        this.receipt = receipt;
        this.foodArr = new IngredientFood[20];
        this.foodSize = 0;
    }

    void add(IngredientFood ingredientFood) {
        for (int i = 0; i < foodSize; i++) {
            if(foodArr[i].getName().equals(ingredientFood.getName())){
                foodArr[i] = ingredientFood;
                return;
            }
        }
        foodArr[foodSize++] = ingredientFood;
    }

    public boolean getCount() {
        for (int i = 0; i < receipt.getSize(); i++) {
            String name = receipt.getIngrNames()[i];
            int nedd = receipt.getIngCount()[i];
            boolean found = false;
            for (int j = 0; j < foodSize; j++) {
                if(foodArr[j].getName().equals(name) && foodArr[j].getSize() >= nedd){
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;

    }

    void getReceipt(){
        if (getCount()){
        }
        for (int i = 0; i < receipt.getSize(); i++) {
            String name = receipt.getIngrNames()[i];
            int need = receipt.getIngCount()[i];
            for (int j = 0; j < foodSize; j++) {
                if(foodArr[j].getName().equals(name)) {
                    foodArr[j].useQuantity(need);
                    break;
                }
            }
        }
        System.out.println("Ovqat muvofaqiyatli tayyorlandi");
    }
    public boolean hasFood(){
        return getCount();
    }
}
