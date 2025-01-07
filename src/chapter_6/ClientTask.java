package chapter_6;

public class ClientTask {
    public static void main(String[] args) {
        Client c = new Client(100, 200);
        c.addSum(2000);
        c.addSum(1500);
        System.out.println(c.isActive());
        System.out.println(c.sms(3));
        System.out.println(c.call(2));
    }
}

class Client {
    int call;
    int sms;
    int sum;

    public Client(int minute, int sms) {
        this.call = minute;
        this.sms = sms;
    }

    public void addSum(int sum) {
        this.sum += sum;
    }

    public boolean isActive() {
        return sum == 0;
    }

    public int call(int minute) {

       return sum -= this.call * minute;
    }
    public int sms(int count){
        return sum -= sms * count;
    }
}