
import Application.App;
import Application.Model.Book;
import Application.Repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.List;

/**
 * NOTE: the tests here RELY on you comp
 */
@SpringBootTest(classes = App.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    private Method[] methods;
    private Method m1;
    private Method m2;
    private Method m3;
    @BeforeEach
    public void setUp() {
        // Clear the repository before each test
        bookRepository.deleteAll();
        methods = BookRepository.class.getDeclaredMethods();
//        getting the methods the trainee will write without spoiling the answers via reflection....
        for(int i = 0; i < methods.length; i++){
            if(methods[i].getName().toLowerCase().contains("or") && !methods[i].toString().contains("thor")){
                m3 = methods[i];
            }else if(methods[i].getName().toLowerCase().contains("title")){
                m1 = methods[i];
            }else if(methods[i].getName().toLowerCase().contains("available")){
                m2 = methods[i];
            }
        }
    }

    @Test
    public void testFindBookByIsbn() {
        // Create a book with a specific ISBN
        long isbn = 1234567890;
        Book book = new Book();
        book.setIsbn(isbn);
        bookRepository.save(book);

        // Retrieve the book by ISBN
        Book foundBook = bookRepository.findBookByIsbn(isbn);

        // Assert that the retrieved book is not null and has the correct ISBN
        Assertions.assertNotNull(foundBook);
        Assertions.assertEquals(isbn, foundBook.getIsbn());
    }

    @Test
    public void testFindBooksByAuthor() {
        // Create books with the same author
        String author = "John Doe";
        Book book1 = new Book();
        book1.setAuthor(author);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setAuthor(author);
        bookRepository.save(book2);

        // Retrieve books by author
        List<Book> foundBooks = bookRepository.findBooksByAuthor(author);

        // Assert that the list of found books is not empty and contains the correct number of books
        Assertions.assertFalse(foundBooks.isEmpty());
        Assertions.assertEquals(2, foundBooks.size());
    }

    @Test
    public void testFindBooksByAuthorAndDateAdded() {
        // Create a book with a specific author and dateAdded
        String author = "Jane Smith";
        Timestamp dateAdded = new Timestamp(System.currentTimeMillis());
        Book book = new Book();
        book.setAuthor(author);
        book.setDateAdded(dateAdded);
        bookRepository.save(book);

        // Retrieve books by author and dateAdded
        List<Book> foundBooks = bookRepository.findBooksByAuthorAndDateAdded(author, dateAdded);

        // Assert that the list of found books is not empty and contains the correct book
        Assertions.assertFalse(foundBooks.isEmpty());
        Assertions.assertEquals(book, foundBooks.get(0));
    }

    @Test
    public void testFindBookByTitle() throws InvocationTargetException, IllegalAccessException {
        if(m1==null){
            Assertions.fail("You haven't written the get by title query yet.");
        }
        // Create a book with a specific title
        String title = "Invisible Cities";
        Book book = new Book();
        book.setTitle(title);
        bookRepository.save(book);

        // Retrieve the book by title
        Book foundBook = (Book) m1.invoke(bookRepository, "Invisible Cities");

        // Assert that the retrieved book is not null and has the correct title
        Assertions.assertNotNull(foundBook);
        Assertions.assertEquals(title, foundBook.getTitle());
    }

    @Test
    public void testFindBooksByAvailability() throws InvocationTargetException, IllegalAccessException {
        if(m1==null){
            Assertions.fail("You haven't written the get by available query yet.");
        }
        // Create available books
        Book book1 = new Book();
        book1.setAvailable(true);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setAvailable(true);
        bookRepository.save(book2);

        // Create unavailable books
        Book book3 = new Book();
        book3.setAvailable(false);
        bookRepository.save(book3);

        // Retrieve available books
        List<Book> foundBooks = (List<Book>) m2.invoke(bookRepository, true);

        // Assert that the list of found books is not empty and contains the correct number of books
        Assertions.assertFalse(foundBooks.isEmpty());
        Assertions.assertEquals(2, foundBooks.size());
    }

    @Test
    public void testFindBooksByDateAddedOrLastDateWithdrawn() throws InvocationTargetException, IllegalAccessException {
        if(m1==null){
            Assertions.fail("You haven't written the get by date added or last date withdrawn query yet.");
        }
        // Create a book with a specific dateAdded and lastDateWithdrawn
        Timestamp dateAdded = new Timestamp(System.currentTimeMillis());
        Timestamp lastDateWithdrawn = new Timestamp(System.currentTimeMillis());
        Book book = new Book();
        book.setDateAdded(dateAdded);
        book.setLastDateWithdrawn(lastDateWithdrawn);
        bookRepository.save(book);

        // Retrieve books by dateAdded or lastDateWithdrawn
        List<Book> foundBooks = (List<Book>) m3.invoke(bookRepository, dateAdded, lastDateWithdrawn);

        // Assert that the list of found books is not empty and contains the correct book
        Assertions.assertFalse(foundBooks.isEmpty());
        Assertions.assertEquals(book, foundBooks.get(0));
    }
}