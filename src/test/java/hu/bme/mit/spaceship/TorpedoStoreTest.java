package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }
    @Test 
    void if_fire_succes_torpedo_number_decreasing(){
        TorpedoStore store=new TorpedoStore(7,0.0);
        boolean result=store.fire(4);
        assertTrue(result);
        assertEquals(3, store.getTorpedoCount());
    }
    @Test 
    void if_fire_fail_torpedo_number_staySame(){
        TorpedoStore store=new TorpedoStore(7,1.0);
        boolean result=store.fire(1);
        assertFalse(result);
        assertEquals(7, store.getTorpedoCount());
    }
    @Test
    void fire_more_than_available_exception(){
        TorpedoStore store=new TorpedoStore(2,1.0);
        assertThrows(IllegalArgumentException.class, ()->store.fire(3));
    }
}
