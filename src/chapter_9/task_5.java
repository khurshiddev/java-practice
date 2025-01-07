package chapter_9;

public class task_5 {
    public static void main(String[] args) {

//        Book book = new Book("O'tkan kunlar", 20000);
//        BookShop11 bookShop = new BookShop11("Kitoblar olami", 2_000_000);
//        System.out.println(bookShop.buyBook(book, 20));
//        System.out.println(bookShop.hasBook());
//        bookShop.hasBook(book);
//        System.out.println(bookShop.sell(book, 10));
//        System.out.println(bookShop.getMoney());

        Book book1 = new Book("C++", 20_000);
        Book book2 = new Book("Java", 25_000);
        Book book3 = new Book("Kotlin", 25_000);
        BookShop11 shop = new BookShop11("Kitoblar olami", 1_000_000);

        // Testlar
        checkTest(false, shop.hasBook());  // Do'konda kitob yo'q
        checkTest(false, shop.hasBook(book1));  // book1 yo'q
        checkTest(0, shop.sell(book1, 1));  // book1 sotilmaydi, mavjud emas
        checkTest(40, shop.buyBook(book1, 40));  // 40 ta book1 sotib olinadi
        checkTest(800_000, shop.getMoney());  // Pul 200,000 so'm kamaydi
        checkTest(8, shop.buyBook(book2, 20));  // 20 ta book2 sotib olinadi
        checkTest(true, shop.hasBook());  // Do'konda kitoblar bor
        checkTest(true, shop.hasBook(book1));  // book1 bor
        checkTest(1, shop.sell(book1, 1));  // 1 ta book1 sotiladi
        checkTest(0, shop.sell(book3, 1));  // book3 mavjud emas
        checkTest(800_000, shop.getMoney());  // Pul o'zgarmaydi (book3 sotilmagan)
        checkTest(39, shop.getCount(book1));  // book1 miqdori 39 bo'ladi
        checkTest(47, shop.getCount());  // Jami kitoblar soni 47
        checkTest("Kitoblar olami", shop.getBookShopName());  // Do'kon nomi to'g'ri
    }

    private static void checkTest(Object result, Object expected) {
        if (result == null && expected != null || result != null && !result.equals(expected)) {
            throw new ArithmeticException("Natija xato: " + result + " expected: " + expected);
        }
    }
}
//class Book {
//    public Book(String name, int cost) {
//    }
//}
//class BookShop11 {
//    public BookShop11(String name, int money) {
//    }
//
//    public int buyBook(Book book, int count) {
//        return 0;
//    }
//    public boolean hasBook() {
//        return false;
//    }
//    public boolean hasBook(Book book) {
//        return false;
//    }
//    public int sell(Book book, int count) {
//        return 0;
//    }
//    public int getMoney() {
//        return 0;
//    }
//    public int getCount() {
//        return 0;
//    }
//    public int getCount(Book book) {
//        return 0;
//    }
//    public String getBookShopName() {
//        return "";
//    }
//}


class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}

class BookShop11 {
    private Book[] books;
    private int[] counts;
    private String libraryName;
    private int money;
    private int bookCount;

    public BookShop11(String libraryName, int money) {
        books = new Book[100];
        this.counts = new int[100];
        this.libraryName = libraryName;
        this.money = money;
        this.bookCount = 0;


    }

    public int buyBook(Book book, int count) {;
        int cost = book.getPrice() * count;
        if (money >= cost) {
            int index = indexOf(book);
            if (index == -1) {
                books[bookCount] = book;
                counts[bookCount] = count;
                bookCount++;
            } else {
                counts[index] += count;
            }
            money -= cost;
            return count;
        }
        return 0;
    }

    public boolean hasBook() {
        return bookCount > 0;
    }

    public boolean hasBook(Book book) {
        return indexOf(book) != -1;
    }

    public int getMoney() {
        return money;
    }

    public int sell(Book book, int count) {
        int isCheckBook = indexOf(book);
        if (isCheckBook != -1 && counts[isCheckBook] >= count) {
            counts[isCheckBook] -= count;
            money += book.getPrice() * count;
            return count;

        }
        return 0;
    }

    public int getCount() {
        int allCount = 0;
        for (int i = 0; i < bookCount; i++) {
            allCount += counts[i];
        }
        return allCount;
    }

    public int getCount(Book book) {
        int countOf = indexOf(book);
        if (countOf != -1) {
            return counts[countOf];
        }
        return 0;
    }

    public String getBookShopName() {
        return libraryName;
    }


    private int indexOf(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getName().equals(book.getName())) {
                return i;
            }
        }
        return -1;
    }
}