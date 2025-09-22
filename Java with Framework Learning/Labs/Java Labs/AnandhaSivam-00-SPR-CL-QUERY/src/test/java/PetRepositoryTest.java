import Application.App;
import Application.Model.Pet;
import Application.Repository.PetRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = App.class)
public class PetRepositoryTest {
    @Autowired
    PetRepository petRepository;

    /**
     * clear the entities prior to every test
     */
    @BeforeEach
    public void setUp(){
        petRepository.deleteAll();
    }

    /**
     * Retrieving all "Cat" species should retrieve Tommy and Whiskers, but not Fido.
     */
    @Test
    public void lab1test(){
        Pet p1 = petRepository.save(new Pet("Tommy", "Cat", 3));
        Pet p2 = petRepository.save(new Pet("Fido", "Dog", 3));
        Pet p3 = petRepository.save(new Pet("Whiskers", "Cat", 20));
        List<Pet> actual = petRepository.lab1("Cat");
        Assertions.assertTrue(actual.contains(p1));
        Assertions.assertTrue(actual.contains(p3));
        Assertions.assertFalse(actual.contains(p2));
    }

    /**
     * Retrieving all pets that are named "Fido" or 3 years old should return "Tommy" and "Fido".
     */
    @Test
    public void lab2test(){
        Pet p1 = petRepository.save(new Pet("Tommy", "Cat", 3));
        Pet p2 = petRepository.save(new Pet("Fido", "Dog", 3));
        Pet p3 = petRepository.save(new Pet("Whiskers", "Cat", 20));
        List<Pet> actual = petRepository.lab2("Fido", 3);
        Assertions.assertTrue(actual.contains(p1));
        Assertions.assertTrue(actual.contains(p2));
        Assertions.assertFalse(actual.contains(p3));
    }

    /**
     * Retrieving the average age of all pets should return 9 within a range of .0001 (due to floating point math.)
     */
    @Test
    public void lab3test(){
        Pet p1 = petRepository.save(new Pet("Tommy", "Cat", 4));
        Pet p2 = petRepository.save(new Pet("Fido", "Dog", 3));
        Pet p3 = petRepository.save(new Pet("Whiskers", "Cat", 20));
        double actual = petRepository.lab3();
        Assertions.assertEquals(9, actual, .0001);
    }
}
