package it.unimib;

public class Library {
    private static final int DEFAULT_SIZE = 10;
    private final Book[] books;

    public Library() {
        books = new Book[DEFAULT_SIZE];
        addDefaultBooks();
    }

    public void addDefaultBooks() {
        Book book1 = new Book("Siddharta",
                new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia",
                new Author("Dante", "Alighieri", 1265), 232);
        Book book3 = new Book("Ivanhoe",
                new Author("Walter", "Scott", 1771), 544);

        for (int i = 0; i < DEFAULT_SIZE; i++) {
            switch (i) {
                case 0:
                    books[0] = book1;
                    break;
                case 1:
                    books[1] = book2;
                    break;
                case 2:
                    // Bug-06a (Correct version: books[2] = book3; or books[i] = book3;)
                    books[20] = book3;
                    break;
            }
        }
    }

    public Library(Book[] books) {
        if (books != null) {
            this.books = books;
        } else {
            this.books = new Book[DEFAULT_SIZE];
        }
    }

    public Library(int size) {
        if (size > 0) {
            books = new Book[size];
        } else {
            books = new Book[DEFAULT_SIZE];
        }
    }

    public Book[] getBooks() {
        return books;
    }

    public int getLibraryCapacity() {
        return books.length;
    }

    public Book findBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(book)) {
                return books[i];
            }
        }
        return null;
    }

    public boolean book(Book book) {
        if (isBookAvailable(book)) {
            findBook(book).setBooked(true);
            return true;
        }
        return false;
    }

    public boolean isBookAvailable(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(book) && !books[i].isBooked()) {
                return true;
            }
        }
        return false;
    }

    public Book borrow(Book book) {
        Book borrowedBook = null;
        if (isBookAvailable(book)) {
            for (int i = 0; i < books.length; i++) {
                if (books[i] != null && books[i].equals(book)) {
                    borrowedBook = books[i];
                    books[i] = null;
                }
            }
        }
        return borrowedBook;
    }

    public Book[] findBooksAuthor(Author author) {
        int authorBooksCounter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getAuthor().equals(author)) {
                authorBooksCounter++;
            }
        }
        Book[] authorBooks = new Book[authorBooksCounter];

        int position = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getAuthor().equals(author)) {
                authorBooks[position] = books[i];
                position++;
            }
        }
        return authorBooks;
    }

    public boolean addBookToLibrary(Book book) {
        if (findBook(book) == null) {
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    books[i] = book;
                    return true;
                }
            }
        }
        return false;
    }
}
