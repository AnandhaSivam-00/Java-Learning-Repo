package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * This class will just run your API, allowing you to manually test via postman, curl, thunder client, etc.
 * Check out 'SearchController' for your tasks.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(App.class);
    }
}
