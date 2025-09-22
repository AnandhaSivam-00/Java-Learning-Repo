package Lab.Service;

import Lab.Model.Grocery;
import Lab.Repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {
    GroceryRepository groceryRepository;
    @Autowired
    public GroceryService(GroceryRepository groceryRepository){
        this.groceryRepository = groceryRepository;
    }

    /**
     * Given a brand new transient grocery (meaning, no such grocery exists yet in the database),
     * persist the grocery to the database (create a new database record for the grocery entity.)
     */
    public Grocery persistGrocery(Grocery grocery){
        return groceryRepository.save(grocery);
    }
    /**
     * findAll() will return all grocery entities stored in the DB table.
     * @return all Grocery entities.
     */
    public List<Grocery> getAllGroceries(){
        return groceryRepository.findAll();
    }

    /**
     * Because findById() returns a type of Optional<Grocery>, we also need to apply .get() to convert the
     * Optional<Grocery> to Grocery. Optionals help the developer to avoid null pointer exceptions.
     * @param id the id of the Grocery entity.
     * @return Grocery entity
     */
    public Grocery getGroceryById(long id){
        //findById returns a type Optional<Grocery>. This helps the developer avoid null pointer
        //exceptions. We can use the method .get() to convert an Optional<Grocery> to Grocery.
        Optional<Grocery> optionalGrocery = groceryRepository.findById(id);
        if(optionalGrocery.isPresent()){
            return optionalGrocery.get();
        }else{
            return null;
        }
    }
    /**
     * Delete a grocery entity of a certain id.
     * @param id
     * @return
     */
    public void deleteGrocery(long id){
        groceryRepository.deleteById(id);
    }
    /**
     * Given a grocery ID, overwrite the contents of the grocery entity.
     * @param id
     * @return
     */
    public void updateGrocery(long id, Grocery replacement){
        //findById returns a type Optional<Grocery>. This helps the developer avoid null pointer
        //exceptions. We can use the method .get() to convert an Optional<Grocery> to Grocery.
        Optional<Grocery> optionalGrocery = groceryRepository.findById(id);
        if(optionalGrocery.isPresent()){
            Grocery grocery = optionalGrocery.get();
            grocery.setName(replacement.getName());
            groceryRepository.save(grocery);
        }

    }
}
