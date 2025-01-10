package chapter_15;

public class InnerAndNestedClass {
    public static void main(String[] args) {

        Books books = new Books("Atomic", 15);
        books.showAllInfo();
        Books.Author auther = books.new Author("James Clear");
        auther.info();

        Books books2 = new Books("Oybegim Mening", 100000);
        books2.showAllInfo();
        Books.Author author2 = books2.new Author("Zarifa Opa");
        author2.info();
    }
}

class Books {
    private String bookName;
    private int bookPrice;

    public Books(String bookName, int bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    void showAllInfo() {
        Publisher.publish(bookName, bookPrice);
    }

    static class Publisher {
        static void publish(String bookName, int bookPrice) {
            System.out.println("------------");
            System.out.println("Book Name = " + bookName + "\nBook Price = " + bookPrice);

        }
    }

    class Author {
        private String bookAuthor;

        public Author(String bookAuthor) {
            this.bookAuthor = bookAuthor;
        }

        void info() {
            System.out.println("Author = " + bookAuthor);
        }
    }

}