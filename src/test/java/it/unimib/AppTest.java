package it.unimib;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testLibraryDefaultConstructor() {
        Library library = new Library();
        assertEquals(10, library.getBooks().length);
    }

    @Test
    public void testLibraryConstructorWithSize() {
        Library library = new Library(100);
        assertEquals(100, library.getBooks().length);
    }

    @Test
    public void testLibraryConstructorWithSize2() {
        Library library = new Library(-4);
        assertEquals(10, library.getBooks().length);
    }

    @Test
    public void testLibraryConstructorWithSize3() {
        Library library = new Library(0);
        assertEquals(10, library.getBooks().length);
    }

    @Test
    public void testLibraryConstructorWithBooks() {
        Book[] books = new Book[15];
        Library library = new Library(books);
        assertEquals(15, library.getBooks().length);
    }

    @Test
    public void testAddBookToLibrary() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);
        Book book3 = new Book("Ivanhoe", new Author("Walter", "Scott", 1771), 544);

        Library library = new Library(books);

        assertTrue(library.addBookToLibrary(book1));
        assertTrue(library.addBookToLibrary(book2));
        assertTrue(library.addBookToLibrary(book3));
    }

    @Test
    public void testAddBookToLibrary2() {
        Book[] books = new Book[1];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);

        Library library = new Library(books);

        assertTrue(library.addBookToLibrary(book1));
        assertFalse(library.addBookToLibrary(book2));
    }

    @Test
    public void testAddBookToLibrary3() {
        Book[] books = new Book[2];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);

        Library library = new Library(books);

        assertTrue(library.addBookToLibrary(book1));
        assertFalse(library.addBookToLibrary(book2));
    }

    @Test
    public void testGetLibraryCapacity1() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);
        Book book3 = new Book("Ivanhoe", new Author("Walter", "Scott", 1771), 544);

        Library library = new Library(books);
        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);

        assertEquals(3, library.getLibraryCapacity());
    }

    @Test
    public void testGetLibraryCapacity2() {
        Library library = new Library(null);
        assertEquals(10, library.getLibraryCapacity());
    }

    @Test
    public void testGetLibraryCapacity3() {
        Library library = new Library(null);
        assertTrue(library.getLibraryCapacity() > 0);
    }

    @Test
    public void testGetLibraryCapacity4() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Library library = new Library(books);
        library.addBookToLibrary(book1);

        Book[] books2 = new Book[library.getLibraryCapacity()];
        Library library2 = new Library(books2);

        assertNotNull(library2.getBooks());
    }

    @Test
    public void testFindBook1() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);
        Book book3 = new Book("Ivanhoe", new Author("Walter", "Scott", 1771), 544);

        Library library = new Library(books);
        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);

        assertNotNull(library.findBook(book1));
        assertNotNull(library.findBook(book2));
        assertNotNull(library.findBook(book3));
    }

    @Test
    public void testFindBook2() {
        Book[] books = new Book[1];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);

        Library library = new Library(books);
        library.addBookToLibrary(book1);

        assertNull(library.findBook(book2));
    }

    @Test
    public void testFindBook3() {
        Book[] books = new Book[1];
        Book book = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);

        Library library = new Library(books);

        assertNull(library.findBook(book));
    }

    @Test
    public void testIsBookAvailable1() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);
        Book book3 = new Book("Ivanhoe", new Author("Walter", "Scott", 1771), 544);

        Library library = new Library(books);
        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);

        assertTrue(library.isBookAvailable(book1));
    }

    @Test
    public void testIsBookAvailable2() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);
        Book book3 = new Book("Ivanhoe", new Author("Walter", "Scott", 1771), 544);

        Library library = new Library(books);
        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);

        assertFalse(library.findBook(book1).isBooked());
        assertTrue(library.isBookAvailable(book1));
        assertTrue(library.book(book1));
        assertFalse(library.isBookAvailable(book1));
    }

    @Test
    public void testIsBookAvailable3() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);

        Library library = new Library(books);

        assertFalse(library.isBookAvailable(book1));
    }

    @Test
    public void testBook1() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);

        Library library = new Library(books);
        library.addBookToLibrary(book1);

        assertTrue(library.book(book1));
        assertNotNull(library.findBook(book1));
        assertEquals("Siddharta", library.findBook(book1).getTitle());

        assertFalse(library.book(book1));
    }

    @Test
    public void testBook2() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);

        Library library = new Library(books);

        library.addBookToLibrary(book1);
        assertFalse(library.book(book2));
    }

    @Test
    public void testBook3() {
        Book[] books = new Book[3];
        Book book1 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);

        Library library = new Library(books);

        assertFalse(library.book(book1));
    }

    @Test
    public void testBorrow1() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);

        Library library = new Library(books);
        library.addBookToLibrary(book1);

        assertNotNull(library.borrow(book1));
        assertNull(library.findBook(book1));
        assertNull(library.borrow(book1));
    }

    @Test
    public void testBorrow2() {
        Book[] books = new Book[3];
        Book book1 = new Book("Siddharta", new Author("Hermann", "Hesse", 1877), 142);
        Book book2 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);

        Library library = new Library(books);

        library.addBookToLibrary(book1);
        assertNull(library.borrow(book2));
    }

    @Test
    public void testBorrow3() {
        Book[] books = new Book[3];
        Book book1 = new Book("La Divina Commedia", new Author("Dante", "Alighieri", 1265), 232);
        Library library = new Library(books);

        assertNull(library.borrow(book1));
    }

    @Test
    public void testFindBooksAuthor1() {
        Book[] books = new Book[3];
        Author author1 = new Author("Hermann", "Hesse", 1877);
        Author author2 = new Author("Dante", "Alighieri", 1265);

        Book book1 = new Book("Siddharta", author1, 142);
        Book book2 = new Book("Narcissus and Goldmund", author1, 320);
        Book book3 = new Book("La Divina Commedia", author2, 232);

        Library library = new Library(books);
        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);

        assertEquals(2, library.findBooksAuthor(author1).length);
        assertEquals("Siddharta", library.findBooksAuthor(author1)[0].getTitle());
        assertEquals("Narcissus and Goldmund", library.findBooksAuthor(author1)[1].getTitle());

        assertEquals(1, library.findBooksAuthor(author2).length);
        assertEquals(0, library.findBooksAuthor(new Author("Walter", "Scott", 1771)).length);
    }

    @Test
    public void testFindBooksAuthor2() {
        Book[] books = new Book[3];
        Author author1 = new Author("Hermann", "Hesse", 1877);

        Library library = new Library(books);

        assertEquals(0, library.findBooksAuthor(author1).length);
    }

    @Test
    public void testFindBooksAuthor3() {
        Book[] books = new Book[3];
        Author author1 = new Author("Hermann", "Hesse", 1877);
        Book book1 = new Book("Siddharta", author1, 142);

        Library library = new Library(books);
        library.addBookToLibrary(book1);

        assertEquals(1, library.findBooksAuthor(author1).length);
        assertEquals("Siddharta", library.findBooksAuthor(author1)[0].getTitle());
    }
}
