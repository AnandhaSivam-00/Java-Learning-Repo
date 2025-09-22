package Application.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long isbn;
    private String title;
    private String author;
    private boolean available;
    private int pages;
    private Timestamp dateAdded;
    private Timestamp lastDateWithdrawn;

    public Book(long isbn, String title, String author, boolean available, int pages, Timestamp dateAdded, Timestamp lastDateWithdrawn) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = available;
        this.pages = pages;
        this.dateAdded = dateAdded;
        this.lastDateWithdrawn = lastDateWithdrawn;
    }
}
