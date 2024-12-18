package chapter_7.task_2;

public class Bus {
    private int passager;
    private int passagerCount;
    private int ticketSum;

    Bus(Capacity capacity, Ticket ticket) {
        passager = capacity.busCapacity;
        this.passagerCount = 0;
        this.ticketSum = ticket.ticketPrice;
    }

    int inPassager(int inPassager) {
        if (passagerCount + inPassager <= passager) {
            passagerCount += inPassager;
            ticketSum = inPassager;
            System.out.println(passagerCount + " In passegars");
        } else {
            System.out.println("Bus is full");
        }
        return passagerCount;
    }

    int outPassenger(int outPassenger) {
        if (passagerCount - outPassenger >= 0) {
            passagerCount -= outPassenger;
            ticketSum = outPassenger;
            System.out.println(passagerCount + " outPassagers");
        } else {
            System.out.println("bus is empty ");
        }
        return passagerCount;
    }

    int getBalance() {
        System.out.println(ticketSum);
        return ticketSum;
    }
    boolean isFull(){
        passager = passagerCount;
        return true;
    }
    boolean isEmpty(){
        if(passagerCount == 0){
            return true;
        }
        return false;
    }

}
