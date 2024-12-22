package chapter_9;
import java.util.Arrays;
public class BookShop {
    public static void main(String[] args) {

        Book1 book1 = new Book1("C++", 20_000);
        Book1 book2 = new Book1("Java", 25_000);
        Book1 book3 = new Book1("Kotlin", 25_000);
        BookShop1 shop = new BookShop1("Kitoblar olami",1_000_000);
        checkTest(false, shop.hasBook());
        checkTest(false, shop.hasBook(book1));
        checkTest(0, shop.sell(book1,1));
        checkTest(40,shop.buyBooks(book1, 40));
        checkTest(200_000, shop.getBalance());
        checkTest(8, shop.buyBooks(book2, 20));
        checkTest(true, shop.hasBook());
        checkTest(true, shop.hasBook(book1));
        checkTest(1, shop.sell(book1,1));
        checkTest(0, shop.sell(book3,1));
        checkTest(0, shop.getBalance());
        checkTest(39 , shop.getBookCount(book1));
        checkTest(47, shop.getBookCountInBookShop());
        checkTest("Kitoblar olami", shop.getBookShopName());
    }
    private static void checkTest(Object result, Object expected) {
        if (result != expected && !expected.equals(result)) {
            throw new ArithmeticException("Natija xato");
        }
    }
}



class Book1 {
    private String bookName;
    private int cost;

    Book1(String bookName, int cost) {
        this.bookName = bookName;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getBookName() {
        return bookName;
    }
}

class BookShop1 {
    private int balance;
    private String name;
    private Book1[] books;
    private int[] amounts;
    private int size = 10;
    private int index = 0;

    BookShop1(String name,int balance ) {
        this.balance = balance;
        this.name = name;

        books = new Book1[size];
        amounts = new int[size];
    }

    int buyBooks(Book1 book1, int count) {
        if (book1.getCost() > this.balance) return 0;
        int bookIndex = indexOfBookInShop(book1);
        if (bookIndex == -1) {
            books[index] = book1;
            amounts[index] = 0;
            bookIndex = index;
            checkMassToLimit();
            index++;
        }
        if (book1.getCost() * count <= balance) {
            amounts[bookIndex] += count;
            this.balance -= book1.getCost() * count;
            return count;
        }
        int buyBookCount = this.balance / book1.getCost();
        amounts[bookIndex] += buyBookCount;
        this.balance -= book1.getCost() * buyBookCount;
        return buyBookCount;
    }

    boolean hasBook() {
        boolean result = false;
        for (int i = 0; i < index; i++) {
            result |= amounts[i] > 0;
        }
        return result;
    }

    boolean hasBook2() {
        for (int i = 0; i < index; i++) {
            if (amounts[i] > 0) return true;
        }
        return false;
    }

    boolean hasBook(Book1 book1) {
        int bookIndex = indexOfBookInShop(book1);
        if (bookIndex == -1) return false;
        return amounts[bookIndex] > 0;
    }

    public int getBalance() {
        return balance;
    }

    public int sell(Book1 book1, int count) {
        int bookIndex = indexOfBookInShop(book1);
        if (bookIndex == -1) return 0;
        if (amounts[bookIndex] >= count) {
            amounts[bookIndex] -= count;
            balance += book1.getCost() * count;
            return count;
        }
        int sellBookCount = amounts[bookIndex];
        amounts[bookIndex] = 0;
        balance += book1.getCost() * sellBookCount;
        return sellBookCount;
    }

    int getBookCountInBookShop() {
        int count = 0;
        for (int i = 0; i < index; i++) {
            count += amounts[i];
        }
        return count;
    }

    int getBookCount(Book1 book1) {
        int indexBook = indexOfBookInShop(book1);
        if (indexBook == -1) return 0;
        return amounts[indexBook];
    }

    String getBookShopName(){
        System.out.println("magazin nomi" + name);
        return name;
    }

    private void checkMassToLimit() {
        if (index == books.length) {
            size += size >> 1;
            this.books = Arrays.copyOf(books, size);
            this.amounts = Arrays.copyOf(amounts, size);
        }
    }

    private int indexOfBookInShop(Book1 book1) {
        for (int i = 0; i < index; i++) {
            if (books[i].getCost() == book1.getCost() && books[i].getBookName() == book1.getBookName())
                return i;
        }
        return -1;
    }
}

