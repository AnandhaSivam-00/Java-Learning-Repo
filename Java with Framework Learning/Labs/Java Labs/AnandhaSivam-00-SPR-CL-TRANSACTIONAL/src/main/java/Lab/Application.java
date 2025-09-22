package Lab;

import Lab.Exceptions.InvalidTonnageException;
import Lab.Exceptions.NegativeWeightException;
import Lab.Model.Container;
import Lab.Model.Ship;
import Lab.Service.ContainerService;
import Lab.Service.ShipService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * The @SpringBootApplication annotation enables automatic configuration of a Spring App.
 * Checkout the ContainerService for implementation and ShipService for the code you need to change.
 */
@SpringBootApplication
public class Application {


	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = SpringApplication.run(Application.class);
		ContainerService containerService = applicationContext.getBean(ContainerService.class);
		ShipService shipService = applicationContext.getBean(ShipService.class);
//		this is to allow spring to fully set up prior to producing output
		Thread.sleep(500);
		System.out.println("First, let's show off the working functionality of transactions & rollbacks for containers.");
		System.out.println("Adding a valid set of containers and then retrieving them: ");
		List<Container> validContainers = new ArrayList<>();
		validContainers.add(new Container("toys", 5));
		validContainers.add(new Container("candy", 5));
		try{
			containerService.addListContainers(validContainers);
		} catch (NegativeWeightException e) {
			System.out.println("NegativeWeightException is thrown here, the transaction should roll back," +
					"and no containers from the list would be persisted.");
		}finally {
			System.out.println("Current containers: " + containerService.getAllContainers());
		}
		System.out.println("Now let's make sure that an invalid list of containers is not persisted at all - " +
				"so, the 'books' container should not be posted because we assume the whole batch of container input" +
				" is erroneous.");
		List<Container> invalidContainers = new ArrayList<>();
		invalidContainers.add(new Container("books", 10));
		invalidContainers.add(new Container("helium", -1));
		try{
			containerService.addListContainers(validContainers);
		} catch (NegativeWeightException e) {
			System.out.println("NegativeWeightException is thrown here, the transaction should roll back," +
					"and no containers from the list would be persisted.");
		}finally {
			System.out.println("Current containers: " + containerService.getAllContainers());
		}
		System.out.println("Next, let's test your ships functionality. These two ships ought to be correctly persisted: ");
		List<Ship> validShipList = new ArrayList<>();
		validShipList.add(new Ship("ever given", 1000));
		validShipList.add(new Ship("beagle", 5));
		try{
			shipService.addListShips(validShipList);
		} catch (InvalidTonnageException e) {
			System.out.println("InvalidTonnageException is thrown here, the transaction should roll back," +
					"and no ships from the list would be persisted.");
		}finally {
			System.out.println("Current ships: " + shipService.getAllShips());
		}
		System.out.println("Finally, let's make sure that the transaction rolls back when an invalid list of ships" +
				" causes an InvalidTonnageException from 'ted balashov's kayak.' That means neither the titanic" +
				" nor nautilis should be persised.");
		List<Ship> invalidShipList = new ArrayList<>();
		invalidShipList.add(new Ship("nautilis", 50));
		invalidShipList.add(new Ship("ted balashov's kayak", -1));
		invalidShipList.add(new Ship("titanic", 2));
		try{
			shipService.addListShips(invalidShipList);
		} catch (InvalidTonnageException e) {
			System.out.println("InvalidTonnageException is thrown here, the transaction should roll back," +
					"and no ships from the list would be persisted.");
		}finally {
			System.out.println("Current ships: " + shipService.getAllShips());
		}
	}
}