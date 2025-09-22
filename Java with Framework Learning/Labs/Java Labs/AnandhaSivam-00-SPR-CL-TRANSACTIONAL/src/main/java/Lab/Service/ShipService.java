package Lab.Service;

import Lab.Exceptions.InvalidTonnageException;
import Lab.Model.Ship;
import Lab.Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Using the Transactional annotation, cause the methods of this Service class to roll back the current
 * database transaction when the InvalidTonnageException is thrown. This will wrap all
 * methods in this class inside of a database transaction, which will prevent incomplete updates in the event of an
 * exception being thrown. It should be assigned to rollback the transaction for some exception, hence the rollbackFor.
 * You can test this by attempting to persist a list of ships where some ship in the JSON has a negative tonnage, then
 * attempting to get all ships. No ships should be persisted if any ship in the array has a negative or zero
 * tonnage - we're left to assume some form of unwanted user error in that case.
 */
@Service
@Transactional(rollbackFor = InvalidTonnageException.class)
public class ShipService {
    ShipRepository shipRepository;
    @Autowired
    public ShipService(ShipRepository shipRepository){
        this.shipRepository = shipRepository;
    }
    /**
     * this is a bad way to save a list to the repository as you can just use the .saveAll method provided the table
     * has a CHECK constraint to check tonnage, but this gets the point across for the importance of @Transactional
     * @param ships transient ship entities
     * @throws InvalidTonnageException ships can not have negative tonnage (they'd sink)
     */
    public List<Ship> addListShips(List<Ship> ships) throws InvalidTonnageException {
        List<Ship> persistedShips = new ArrayList<>();
        for(int i = 0; i < ships.size(); i++){
            if(ships.get(i).getTonnage()<=0){
                throw new InvalidTonnageException();
            }
            persistedShips.add(shipRepository.save(ships.get(i)));
        }
        return persistedShips;
    }
    /**
     * @return all ship entities
     */
    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }
    /**
     * @return ship entity by id
     */
    public Ship getShipById(long id) {
        return shipRepository.findById(id).get();
    }
}
