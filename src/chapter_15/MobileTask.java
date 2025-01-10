package chapter_15;

public class MobileTask {
    public static void main(String[] args) {
        MobilePhone mob = new MobilePhone("Android");
       mob.setSimCard("Beeline",998906666666L);
       mob.showSimcardInfo();


    }
}

class MobilePhone {
    private String phoneModel;
    private SimCard simCard;

    public MobilePhone(String phoneModel) {
        this.phoneModel = phoneModel;

    }

    public void setSimCard(String operator, long number){
        this.simCard = new SimCard(operator,number);
    }

    public void showSimcardInfo(){
        if(simCard != null){
            simCard.showInfo();
        }else {
            System.out.println("no sim card");
        }
    }

    static class SimCard {
        private String operator;
        private long numbers;

        public SimCard(String operator, long numbers) {
            this.operator = operator;
            this.numbers = numbers;
        }

        void showInfo() {
            System.out.println("Information ");
            System.out.println("Operator = " + operator);
            System.out.println("Number = " + numbers);
        }


    }
}

