package Lab;

import Lab.Model.Grocery;
import Lab.Model.Store;
import Lab.Service.GroceryService;
import Lab.Service.StoreService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * The @SpringBootApplication annotation enables automatic configuration of a Spring App.
 * Check out the GroceryService for current JPACRUD implementation and StoreService classes for the code you need to
 * change. There is no need to change anything in this class.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class);
        GroceryService groceryService = applicationContext.getBean(GroceryService.class);
        StoreService storeService = applicationContext.getBean(StoreService.class);
        //Demonstrating the functionality of the JPARepository with the Grocery entity.
        System.out.println("First, let's create some groceries, persist them, and then retrieve all groceries.");
        Grocery g1 = groceryService.persistGrocery(new Grocery("banana"));
        Grocery g2 = groceryService.persistGrocery(new Grocery("apple"));
        Grocery g3 = groceryService.persistGrocery(new Grocery("milk"));
        System.out.println(groceryService.getAllGroceries());
        System.out.println("Let's get groceries by id, for id 1.");
        System.out.println(groceryService.getGroceryById(1L));
        System.out.println("Getting a grocery by a non-existent id, such as 99, returns null.");
        System.out.println(groceryService.getGroceryById(99L));
        System.out.println("Let's delete grocery of id 2 and then get all groceries.");
        groceryService.deleteGrocery(2L);
        System.out.println(groceryService.getAllGroceries());
        System.out.println("Let's update grocery of id 1 to be 'melon.'");
        groceryService.updateGrocery(1L, new Grocery("melon"));
        System.out.println(groceryService.getGroceryById(1L));
        //Testing out your Service class implementations with the Store entity.
        System.out.println("Creating some stores, persisting them, and retrieving all stores.");
        Store s1 = storeService.persistStore(new Store("ted balashov's farmers market", "123 main street"));
        Store s2 = storeService.persistStore(new Store("super mart", "111 1st avenue"));
        System.out.println(storeService.getAllStores());
        System.out.println("Let's get a store of id 1.");
        System.out.println(storeService.getStoreById(1L));
        System.out.println("Let's try deleting store of id 2 and then getting all stores.");
        storeService.deleteStore(2L);
        System.out.println(storeService.getAllStores());
        System.out.println("Finally, let's try updating a store and then getting all stores.");
        storeService.updateStore(1L, new Store("ted balashov's corner market",  "123 main street"));
        System.out.println(storeService.getAllStores());


    }
}
