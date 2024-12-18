package chapter_6;

public class task_3 {
    public static void main(String[] args) {
    Client c = new Client(100,200);
    c.addSum(2000);
    c.addSum(1500);
    c.isActive();
    c.sms(3);
    c.call(2);
    }
}

class Client{
    private int minute;
    private int message;
    private int balance;

    Client(int minute,int message){
        this.minute = minute;
        this.message = message;
        this.balance = 0;
    }
    void addSum (int sum){
         this.balance += sum;
         }

    boolean isActive(){
        boolean isCheck = balance > 0;
        System.out.println("balance is active = " + isCheck);
        return isCheck;
    }
    void call (int call){
        if(balance >=call){
            balance -= call;

            System.out.println(balance +" = call minute");
    }else{
            System.out.println("cash is empty ");
        }
}
void sms(int sms) {
    if (balance > sms) {
        balance -= sms;
        System.out.println(balance + " = sms count");
    } else {
        System.out.println("cash is empty ");
    }
  }
}
