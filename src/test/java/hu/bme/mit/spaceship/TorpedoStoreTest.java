package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertTrue(result);
        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void fire_FailureRateAlwaysFails() {
        // Arrange: 1 torpedó, 1.0 (100%) hibaarány
        TorpedoStore store = new TorpedoStore(1, 1.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertFalse(result);
    }

    @Test
    void fire_ThrowsExceptionWhenEmpty() {
        // Arrange: üres tároló
        TorpedoStore store = new TorpedoStore(0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(1);
        });
    }

    @Test
    void getTorpedoCount_InitialValueMatches() {
        // Arrange
        TorpedoStore store = new TorpedoStore(10);

        // Act & Assert
        assertEquals(10, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }
}