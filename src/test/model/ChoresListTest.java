package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Represents test for ChoresList
 */
public class ChoresListTest {
    private ChoresList choresList1;
    private ChoresList choresList2;

    @BeforeEach
    void runBefore(){
        choresList1 = new ChoresList();
        choresList2 = new ChoresList();
        new Member("arun", "dishes");

    }
    @Test
    void testAddChore(){
        Chore chore1 = new Chore("dishes","arun");
        choresList1.addChore(chore1);
        assertEquals(1, choresList1.getListOfChores().size());
        assertEquals(chore1, choresList1.getListOfChores().get(0));
        assertEquals(0, choresList2.getListOfChores().size());
        assertTrue(choresList2.getListOfChores().isEmpty());
    }
}
