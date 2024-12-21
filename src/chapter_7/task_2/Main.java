package chapter_7.task_2;

public class Main {
    public static void main(String[] args) {
        Capacity c = new Capacity(100);
        Ticket t = new Ticket(1400);
        Bus b = new Bus(c, t);
        int t1 = b.inPassager(95);
        int t6 = b.inPassager(5);
        int t7 = b.inPassager(5);
        int t2 = b.outPassager(5);
        int t3 = b.outPassager(10);
        int t4 = b.outPassager(85);
        b.getBalance();
        b.isFully();
        b.isEmpty();
        System.out.println(b.isFully());
        System.out.println(b.isEmpty());

    }
}
