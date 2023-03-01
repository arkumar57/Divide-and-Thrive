package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Represents test for Chore
 */
public class ChoreTest {
    private Chore chore;

    @BeforeEach
    void runBefore(){
        chore = new Chore("Cleaning",null);
    }

    @Test
    void testChore(){
        assertEquals("Cleaning", chore.toString());
        assertNull(chore.getAssignedMember());
    }

}
