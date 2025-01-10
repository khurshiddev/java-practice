package chapter_15;

public class BankAccountTask {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount();
        BankAccount.Transaction tr = bank.new Transaction();
        tr.add(10);
        tr.add(50);
        tr.minus(13);
        bank.displayBalance();
    }
}

class BankAccount {
    private int bankAccountNumber;

    class Transaction {
        void add(int value) {
            bankAccountNumber += value;
        }

        void minus(int value) {
            bankAccountNumber -= value;
        }
    }

    void displayBalance() {
        System.out.println("Bank account real time: " + bankAccountNumber);
    }
}