package chapter_15;

public class BuilderPatternTask {
    public static void main(String[] args) {
        Book book = new Book.BookBuilder("AtomicHabits")
                .setAuthorName("Jon Clear")
                .setPageCount(400)
                .setBookGenre("soft skill")
                .setPublicationYear(2015)
                .build();
    }
}



class Book {
    private String bookName;
    private String authorName;
    private int publicationYear;
    private int pageCount;
    private String bookGenre;

    private Book(String bookName) {
        this.bookName = bookName;
    }

    static class BookBuilder {            // create nested class
        private String bookName;
        private String authorName;
        private int publicationYear;
        private int pageCount;
        private String bookGenre;

        public BookBuilder(String bookName) {
            this.bookName = bookName;
        }

        BookBuilder setBookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        BookBuilder setAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        BookBuilder setPublicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        BookBuilder setPageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        BookBuilder setBookGenre(String bookGenre) {
            this.bookGenre = bookGenre;
            return this;
        }

        Book build() {
            Book book = new Book(bookName);
            book.bookName = bookName;
            book.authorName = authorName;
            book.publicationYear = publicationYear;
            book.pageCount = pageCount;
            book.bookGenre = bookGenre;
            return book;
        }
    }
}