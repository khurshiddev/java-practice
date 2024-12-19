package chapter_7.task_4;

public class MoneyBox {
    private int sum;
    private int currentSum;
    private int currentIndex;

        MoneyBox(int summary){
            this.sum = summary;
            this.currentSum = 0;
            this.currentIndex = 0;
        }

    public void add(Money addMoney) {
            if(isFull()){
                System.out.println("is fully");
            }else {
                currentIndex++;
                currentSum += addMoney.money;
                System.out.println(currentSum + " money added");
            }
    }
    boolean isEmpty(){
       return currentIndex == 0;
    }

    boolean isFull(){
        return currentSum == sum;

    }

    public int getMoneyCount() {
        return currentIndex;
    }
    public int getAmount() {
        return sum;

    }

}
