package Application;

import Application.Model.Book;
import Application.Repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Check out the
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(App.class);
        BookRepository bookRepository = applicationContext.getBean(BookRepository.class);
//        wait for the spring logs to clear before printing output
        Thread.sleep(500);
        Timestamp time1 = new Timestamp(444444444444L);
        Timestamp time2 = new Timestamp(555555555555L);
        Book b1 = new Book(11111L, "Cosmicomics", "Italo Calvino", true, 200, time1, time1);
        Book b2 = new Book(22222L, "Mr Palomar", "Italo Calvino", true, 300, time2, time2);
        Book b3 = new Book(33333L, "Ficciones", "Jorge Luis Borges", false, 250, time1, time2);
        b1 = bookRepository.save(b1);
        b2 = bookRepository.save(b2);
        b3 = bookRepository.save(b3);
        System.out.println("Demonstrating the use of named queries here.");
        System.out.println("Getting book by ISBN 33333:");
        System.out.println(bookRepository.findBookByIsbn(33333L));
        System.out.println("Getting book by author 'Italo Calvino':");
        System.out.println(bookRepository.findBooksByAuthor("Italo Calvino"));
        System.out.println("Getting book by author 'Italo Calvino' and its date added, in 1987:");
        System.out.println(bookRepository.findBooksByAuthorAndDateAdded("Italo Calvino", time2));

    }
}
