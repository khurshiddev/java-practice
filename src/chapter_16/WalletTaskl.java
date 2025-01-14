package chapter_16;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WalletTaskl {
    public static void main(String[] args) {
        Card card1 = new Card("User1", "1234", 1000);
//        wallet.addCard(card1);
//
//        wallet.spendMoneyFromCard(card1, 700);
//        assertEquals(300, card1.getAmount());


        Card car1 = new Card("Abdulloh", "123443454122", 1000);
        Card car2 = new Card("Abduqodir", "122243454122", 120000);
        Card car3 = new Card("Behzod", "124443454122", 180000);
        Card car4 = new Card("Oybek", "125543454122", 250000);
        Card car5 = new Card("Abdulloh", "123443454122", 500000);
        Wallet wallet = new Wallet(30000);
        wallet.setLogListener(System.out::println);
        wallet.setCardListener(System.out::println);
        List<Card> cards = new ArrayList<>();
        cards.add(car1);
        wallet.spendMoneyFromCard(card1, 700);
//        System.out.println(wallet.getTotalBalance());
        System.out.println(card1.getAmount());
        cards.add(car2);
        cards.add(car3);
        cards.add(car4);
        cards.add(car5);
        wallet.addBalance(88000);
        wallet.addCard(car1);
        wallet.addCard(car2);
        wallet.addCard(car3);
        wallet.addCard(car4);
        wallet.addCard(car5);
        wallet.getAllCards();
        wallet.addCards(cards);
        wallet.spendMoney(200000);

        System.out.println(wallet.getTotalBalance());
        wallet.spendMoneyFromCard(car3, 100000);
        wallet.spendMoneyFromCard(car1, 650000);


    }
}

class Card {
    private String userName, cardName;
    private int amount;

    public Card(String userName, String cardName, int amount) {
        this.userName = userName;
        this.cardName = cardName;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void spendMoney(int value) {
        this.amount -= value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return amount == card.amount && Objects.equals(userName, card.userName) && Objects.equals(cardName, card.cardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, cardName, amount);
    }

    @Override
    public String toString() {
        return "Card{" +
                "userName = '" + userName + '\'' +
                ", cardName = '" + cardName + '\'' +
                ", amount = " + amount +
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

    public void setCardListener(ShowCardInterface cardListener) {
        this.cardListener = cardListener;
    }

    public void setLogListener(LogInterface logListener) {
        this.logListener = logListener;
    }

    public void addCard(Card card) {
        if (check(card) != -1) {
            logListener.sendMessage("bu karta avval qo'shilgan");
        } else {
            logListener.sendMessage("carta qo'shildi");
            cards.add(card);
        }
    }

    public void addCards(List<Card> cards) {
        for (Card card : cards) {
            if (check(card) != -1) {
                cardListener.showCardData(card);
                return;
            }
            cards.add(card);
        }
    }

    public int addBalance(int addBalance) {
        return balance += addBalance;
    }

    public int getTotalBalance() {
        int total = balance;
        for (Card card : cards) {
            total += card.getAmount();
        }
        return total;
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
            logListener.sendMessage(money - balance + " = shuncha pul yetmadi");
        }
    }

    public void spendMoneyFromCard(Card card, int spendMoney) {
        int checkIndex = check(card);
        if (checkIndex != -1) {
            logListener.sendMessage("bu carta hamyonda yo'q");
        } else {
            if (card.getAmount() >= spendMoney) {
                card.spendMoney(spendMoney);
            } else {
                logListener.sendMessage(spendMoney - card.getAmount() + " = shuncha miqdorda pul yetmayapti");
            }

        }

    }

    @Override
    public String toString() {
        return "Wallet{" +
                "cards=" + cards +
                '}';
    }

    private int check(Card card) {
        return cards.indexOf(card);
    }
}