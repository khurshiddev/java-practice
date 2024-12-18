package chapter_7.task_2;

public class Main {
    public static void main(String[] args) {

        Capacity c = new Capacity(100);
        Ticket t = new Ticket(1400);
        Bus b = new Bus(c,t);
        int t1 = b.inPassager(5);
        int t2 = b.outPassenger(5);
        b.getBalance();
        b.isFull();
        b.isEmpty();
        b.getBalance();
    }
}
