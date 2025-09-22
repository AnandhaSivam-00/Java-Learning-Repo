package Lab.Service;

import Lab.Model.Store;
import Lab.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class StoreService {
    StoreRepository storeRepository;
    @Autowired
    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }
    /**
     * TODO: given a transient store, persist the store and return it.
     * @param store a transient store
     * @return the persisted store
     */
    public Store persistStore(Store store){
        return storeRepository.save(store);
    }
    /**
     * TODO: get all store entities
     * @return all store entities
     */
    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }
    /**
     * TODO: given an id of a store, return the store.
     *
     * @param id id of store entity
     * @return a store entity
     */
    public Store getStoreById(long id){
        Optional<Store> optionalStore = storeRepository.findById(id);

        if(optionalStore.isPresent()) {
            return optionalStore.get();
        }
        else {
            return null;
        }
    }
    /**
     * TODO: given an id of an existing store, delete the store
     */
    public void deleteStore(long id){
//        code here
        storeRepository.deleteById(id);
    }
    /**
     * TODO: given an id and some replacement data for a store, overwrite the data of an existing store,
     * and return the updated store.
     * @return the updated store entity
     */
    public Store updateStore(long id, Store replacement){
        Optional<Store> optionalStore = storeRepository.findById(id);

        if(optionalStore.isPresent()) {
            Store store = optionalStore.get();
            store.setName(replacement.getName());
            storeRepository.save(store);

            return store;
        }
        return null;
    }

}
