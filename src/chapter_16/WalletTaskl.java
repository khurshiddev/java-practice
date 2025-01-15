package chapter_16;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WalletTaskl {
    public static void main(String[] args) {
        Card card1 = new Card("Abdulloh", "123443454122", 1000);
        Card card2 = new Card("Abduqodir", "122243454122", 120000);
        Card card3 = new Card("Behzod", "124443454122", 180000);
        Card card4 = new Card("Oybek", "125543454122", 250000);
        Card card5 = new Card("Abdulloh", "123443454122", 500000);
        Wallet wallet = new Wallet(15000);
        wallet.setCardListener(System.out::println);
        wallet.setLogListener(System.out::println);

        wallet.addCard(card1);
        wallet.addCard(card2);
        wallet.addBalance(20000);
        wallet.addCard(card3);

        wallet.addCard(card1);
        wallet.getAllCards();
        System.out.println(wallet.getTotalBalance());
        wallet.spendMoney(650000);
        wallet.spendMoneyFromCard(card1, 150000);
        wallet.spendMoneyFromCard(card4, 80000);
    }
}

class Card {
    private String username, cardNumber;
    private int amount;

    public Card(String username, String cardNumber, int amount) {
        this.username = username;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void spendMoney(int amount) {
        this.amount -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return amount == card.amount && Objects.equals(username, card.username) && Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, cardNumber, amount);
    }

    @Override
    public String toString() {
        return "Card{" +
                "username='" + username + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}

@FunctionalInterface
interface ShowCardInterface {
    void showCardData(Card card);
}

@FunctionalInterface
interface LogInterface {
    void sendMessage(String message);
}

class Wallet {
    private List<Card> cards;
    private ShowCardInterface cardListener;
    private LogInterface logListener;
    private int balance;

    public Wallet(int balance) {
        this.balance = balance;
        cards = new ArrayList<>();
    }

    void addCard(Card card) {
        if (checkCard(card) != -1) {
            logListener.sendMessage("bu avval qoshilgan ");

        } else {
            logListener.sendMessage("karta qoshildi ");
            cards.add(card);
        }
    }

    public void addCards(List<Card> cards) {
        for (Card card : cards) {
            if (checkCard(card) != -1) {
                cardListener.showCardData(card);
                return;
            }
            cards.add(card);
        }
    }

    public void addBalance(int addBalance) {
        balance += addBalance;
    }

    public void setCardListener(ShowCardInterface cardListener) {
        this.cardListener = cardListener;
    }

    public void setLogListener(LogInterface logListener) {
        this.logListener = logListener;
    }

    public int getTotalBalance() {
        int totalBalance = balance;
        for (Card card : cards) {
            totalBalance += card.getAmount();
        }
        return totalBalance;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "cards=" + cards +
                '}';
    }

    public void getAllCards() {

        for (Card card : cards) {
            cardListener.showCardData(card);
        }
    }

    public void spendMoney(int money) {
        if (balance >= money) {
            balance -= money;
        } else {
            logListener.sendMessage(money - balance + " miqdorda naqd pul yetmaydi");
        }

    }

    public void spendMoneyFromCard(Card card, int spendMoney) {
        int index = checkCard(card);
        if (index == -1) {
            logListener.sendMessage("bu karta hamyonda yoq");
        } else {
            if (card.getAmount() >= spendMoney) {
                card.spendMoney(spendMoney);
            } else {
                logListener.sendMessage(spendMoney - card.getAmount() + " miqdorda naqd pul yetmaydi");
            }
        }
    }

    private int checkCard(Card card) {
        return cards.indexOf(card);
    }
}

