import Lab.Model.Store;
import Lab.Service.StoreService;
import Lab.Repository.StoreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * This test suite uses mockito and junit to mock the StoreRepository and test an instance StoreService for each of it's
 * methods to properly invoke exactly what they are intended to do
 */

@ExtendWith(MockitoExtension.class)
public class StoreServiceTestSuite {
    @Mock
    StoreRepository storeRepository;

    @InjectMocks
    StoreService storeService;

    /**
     * This test ensures that the StoreService persistStore method when given a testStore to persist in the database
     * returns back our testStore and is only invoked a single time. This will also confirm no other interactions with
     * the storeRepository.
     */
    @Test
    public void testPersistStore(){
        Store testStore = new Store("test", "test");

        when(storeRepository.save(any(Store.class))).thenReturn(testStore);

        Store actualStore = storeService.persistStore(testStore);

        Assertions.assertEquals(testStore, actualStore);
        verify(storeRepository, times(1)).save(testStore);
        verifyNoMoreInteractions(storeRepository);
    }

    /**
     * This test ensures that the StoreSerivce getAllStores method returns back a List of Stores with a size of two
     * and is only invoked a single time. This will also confirm no other interactions with the storeRepository.
     */
    @Test
    public void testGetAllStores(){
        when(storeRepository.findAll()).thenReturn(List.of(new Store(), new Store()));

        int actualSize = storeService.getAllStores().size();

        Assertions.assertEquals(2, actualSize);
        verify(storeRepository, times(1)).findAll();
        verifyNoMoreInteractions(storeRepository);

    }

    /**
     * This test ensures that the StoreSerivce getStoreById method when given the same long ID returns back our
     * testStore and is only invoked a single time. This will also confirm no other interactions with the storeRepository.
     */
    @Test
    public void testGetStoreByID(){
        Store testStore = new Store(1L,"test", "test");

        when(storeRepository.findById(1L)).thenReturn(Optional.of(testStore));

        Store actualStore = storeService.getStoreById(1L);

        Assertions.assertEquals(testStore, actualStore);
        verify(storeRepository, times(1)).findById(1L);
        verifyNoMoreInteractions(storeRepository);

    }

    /**
     * This test ensures that the StoreSerivce deleteStore method when given anyLong ID will invoke the deleteById
     * in storeRepository a single time. This will also confirm no other interactions with the storeRepository.
     */
    @Test
    public void testDeleteStore(){
        doNothing().when(storeRepository).deleteById(anyLong());

        storeService.deleteStore(anyLong());
        verify(storeRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(storeRepository);
    }

    /**
     * This test ensures that the StoreSerivce updateStore method when given an ID of 1L and testStore to replace that
     * current persisted information in the database returns back our testStore with the updated information
     * and is only invoked a single time. This will also confirm no other interactions with the storeRepository.
     */
    @Test
    public void testUpdateStore(){
        Store testStore = new Store(1L, "test", "test");

        when(storeRepository.findById(1L)).thenReturn(Optional.of(testStore));
        when(storeRepository.save(any(Store.class))).thenReturn(testStore);

        Store actualStore = storeService.updateStore(1L,testStore);

        Assertions.assertEquals(testStore,actualStore);
        verify(storeRepository, times(1)).findById(anyLong());
        verify(storeRepository, times(1)).save(testStore);
        verifyNoMoreInteractions(storeRepository);
    }

}
