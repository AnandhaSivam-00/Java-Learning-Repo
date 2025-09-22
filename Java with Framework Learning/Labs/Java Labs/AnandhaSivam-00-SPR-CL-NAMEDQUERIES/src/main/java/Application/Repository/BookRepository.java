package Application.Repository;

import Application.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * NamedQueries are a powerful feature of JPA repositorties that allow a developer to create a query using naming
 * conventions based on the name of fields in a class and the class name itself. For instance, if you have the 
 * following class:
 * public class Person {
 *    Long id;
 *    String name;
 *    int age;
 * }
 *
 * You can create a named query in a JpaRepository interface using the 'name' and 'age' fields.
 * public interface PersonRepository extends JpaRepository<Person, Long> {
 *    public Person findPersonByName(String name);
 *    
 *    public List<Person> findPersonsByAge(Integer age);
 * }
 *
 * There are two important notes to keep in mind here. The return type and name of the method is important when
 * using named queries. For the first method, we are locating a single person object, so the name is "FindPerson..."
 * and the return type matches this expectation by returning a single Person object. We are locating this person
 * using the field "Name", so the full method name: "findPersonByName" follows a naming convention that JpaRepository
 * expects.
 *
 * For the second method, notice that the proper way to say we want to find multiple persons would be to name
 * the method "FindPeopleByAge", however, the class is 'Person' not 'People'. The most important thing to keep in
 * mind when working with named queries are to match the class and field names.
 * 
 * In this JPA Repository interface, we will be exploring JPA's ability to infer queries from method names. We'll
 * refer to these as query methods. While JPA does allow the developer to include their own database queries, many
 * operations are simple enough that they can be adequately described using a specific method name.
 *
 * Spring can perform different forms of filtering or aggregation based off of the fields provided in your entity.
 * The book class has the following fields provided:
 *     private long id;
 *     private long isbn;
 *     private String title;
 *     private String author;
 *     private boolean available;
 *     private int pages;
 *     private Timestamp dateAdded;
 *     private Timestamp lastDateWithdrawn;
 *
 *     The test cases for this lab will attempt to identify the query methods you've written and run them.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * This will become a usable method when the BookRepository is injected into one of your classes.
     * @param isbn a long that identifies distinct books.
     * @return the book with a particular ISBN
     */
    Book findBookByIsbn(long isbn);
    /**
     * This query will return a List of books that match a certain Author string for the Author field.
     * @param author
     * @return
     */
    List<Book> findBooksByAuthor(String author);

    /**
     * More complex clauses, such as an 'AND' statement, can be written as part of a query method.
     * @param author
     * @param dateAdded
     * @return
     */
    List<Book> findBooksByAuthorAndDateAdded(String author, Timestamp dateAdded);

    /**
     * TODO: Retrieve a book by its title. You may assume that titles are unique and that a single Book entity should
     * be returned, so the return type will be Book.
     */
    Book findBookByTitle(String title);

    /**
     * TODO: Retrieve books by their availability using the field "available" in the class Book. The return type will be List<Book>.
     */
    List<Book> findBookByAvailable(boolean available);

    /**
     * TODO: Retrieve books by their dateAdded OR their lastDateWithdrawn.
     */
    List<Book> findByDateAddedOrLastDateWithdrawn(Timestamp dateAdded, Timestamp lastDateWithdrawn);

}
