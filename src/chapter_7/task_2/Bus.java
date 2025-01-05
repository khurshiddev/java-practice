package chapter_7.task_2;

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
            if(inPassager >= personCount + capacity.capacity ){
                personCount -= inPassager;
                System.out.println(personCount + " shuncha yo'lovchi chiqti" );
            }
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
