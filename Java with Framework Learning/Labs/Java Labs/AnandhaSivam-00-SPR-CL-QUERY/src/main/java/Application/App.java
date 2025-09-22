package Application;

import Application.Model.Pet;
import Application.Repository.PetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Check out the PetRepository class in the Repository package for the code you should modify.
 * This main method is just for manually testing your code.
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(App.class);
        PetRepository petRepository = applicationContext.getBean(PetRepository.class);
//        waiting for the spring logstream to finish setup prior to printing output
        Pet p1 = petRepository.save(new Pet("Tommy", "Cat", 4));
        Pet p2 = petRepository.save(new Pet("Fido", "Dog", 5));
        Pet p3 = petRepository.save(new Pet("Tommy", "Dog", 6));
        System.out.println("Here are all the pets we're working with.");
        System.out.println(petRepository.findAll());
        System.out.println("Let's test out the queries written using the @Query annotation.");
        System.out.println("First, let's retrieve all pets named 'Tommy'.");
        System.out.println(petRepository.example1("Tommy"));
        System.out.println("Next, let's retrieve all Cats named 'Tommy'.");
        System.out.println(petRepository.example2("Tommy", "Cat"));
        System.out.println("Next, let's get the age of the oldest pet.");
        System.out.println(petRepository.example3());
        System.out.println("Now let's try out your queries.");
        System.out.println("First, let's retrieve all Dogs.");
        System.out.println(petRepository.lab1("Dog"));
        System.out.println("Next, let's retrieve all pets that are named Fido OR or 4 years old.");
        System.out.println(petRepository.lab2("Fido", 4));
        System.out.println("Next, let's retrieve the average age of all pets. (If you haven't written the query yet," +
                "\n this will throw an exception.)");
        System.out.println(petRepository.lab3());

    }
}
