package Lab.Service;

import Lab.Exceptions.NegativeWeightException;
import Lab.Model.Container;
import Lab.Model.Ship;
import Lab.Repository.ContainerRepository;
import Lab.Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * The @Transactional annotation wraps every method in this class inside a database transaction, which is a set of
 * database statements that happen in isolation of all other database transactions, and are applied to the database in
 * an all-or-nothing manner. This means that a high volume of database transactions may transpire without having an
 * effect such as a dirty read, or reading data that has been modified in an in-progress transaction. This matters when
 * a Transaction has multiple steps. (for instance, when a single transaction should process 100 database statements
 * for purchasing items from a user's cart, we don't want Spring to make the mistake of reading from an incomplete
 * transaction, as e.g. a request for the total cost of a user's cart could return an erroneous amount, such as only
 * 50 items, if Spring happens to read an incomplete transaction.) The @Transactional annotation is actually using
 * a part of Spring known as Spring AOP (aspect-oriented-programming) to apply the transaction start & commit to every
 * method. Spring AOP actually overrides some method(s) you define (in this case, all methods of this class) to apply
 * additional code to them as Spring is loading this class as a Bean.
 *
 * You can test this by attempting to persist a list of containers where some container has a negative
 * weight, then  attempting to get all ships. No ships should be persisted if any container in the array has a negative
 * or zero weight - we're left to assume some form of unwanted user error in that case. If that happens, the Service
 * will throw an NegativeWeightException, triggering a rollback of the current transaction.
 *
 * there is no need to modify this class.
 */
@Transactional(rollbackFor = NegativeWeightException.class)
@Service
public class ContainerService {
    ContainerRepository containerRepository;
    ShipRepository shipRepository;
    @Autowired
    public ContainerService(ContainerRepository containerRepository, ShipRepository shipRepository){
        this.containerRepository = containerRepository;
        this.shipRepository = shipRepository;
    }
    /**
     * this is a bad way to save a list to the repository as you can just use the .saveAll method provided the table
     * has a CHECK constraint to check tonnage, but this gets the point across for the importance of @Transactional.
     *
     * @param id
     * @param containers transient container entities
     * @throws NegativeWeightException ships can not have negative tonnage (they'd sink), containers can not have
     *                                 negative weight (they'd fly away)
     */
    public List<Container> addListContainers(List<Container> containers) throws NegativeWeightException {
        List<Container> persistedContainers = new ArrayList<>();
        for(int i = 0; i < containers.size(); i++){
            if(containers.get(i).getWeight()<=0){
                throw new NegativeWeightException();
            }
            Container newContainer = containerRepository.save(containers.get(i));
            persistedContainers.add(newContainer);
        }
        return persistedContainers;
    }

    /**
     * @return all container entities
     */
    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }
    /**
     * @return container entities by id
     */
    public Container getContainerById(long id) {
        return containerRepository.findById(id).get();
    }
}