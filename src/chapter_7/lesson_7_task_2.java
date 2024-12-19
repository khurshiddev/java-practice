package chapter_7;

public class lesson_7_task_2 {
    public static void main(String[] args) {
        Capacity c = new Capacity(100);
        Ticket t = new Ticket(1400);
        Bus b = new Bus(c, t);
        int t1 = b.inPassager(95);
        int t6 = b.inPassager(5);
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

class Capacity {
    int capacity;

    Capacity(int capacity) {
        this.capacity = capacity;
    }
}

class Ticket {
    int ticketPrice;

    Ticket(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

class Bus {
    Capacity capacity;
    Ticket ticket;
    int personCount;
    int outPassanger;
    int getBalance;
    int inBusPassager;

    Bus(Capacity capacity, Ticket ticket) {
        this.personCount = 0;
        this.outPassanger = 0;
        this.getBalance = 0;
        this.capacity = capacity;
        this.ticket = ticket;
        this.inBusPassager = 0;
    }

    int inPassager(int inPassager) {
        if (inPassager + personCount <= capacity.capacity ) {
            personCount += inPassager;
            getBalance = personCount * ticket.ticketPrice;
            System.out.println(personCount + " shuncha yo'lovchi chiqti");
        } else {
            System.out.println("Avtobusda joy yo'q yo'lovchilar sig'madi ");
        }
        return personCount;
    }

    int outPassager(int outPassager) {
        if(outPassager > personCount ) {
            System.out.println(outPassager + " Buncha yo'lovchi mavjud emas");
            return 0;
        }else {
            personCount -= outPassager;
            System.out.println(personCount + " shuncha yo'lovchi qoldi");
        }
        return personCount;
    }

    int getBalance() {
        System.out.println("umumiy balance " + getBalance);
        return getBalance = personCount * ticket.ticketPrice;
    }

    boolean isFully() {
        if (personCount == capacity.capacity) {
            return true;
        } else {
            return false;
        }
    }

    boolean isEmpty() {
        return personCount == 0;
    }
}