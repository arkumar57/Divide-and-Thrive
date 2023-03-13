package persistence;

import model.Home;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * / Tests the JSON reader
 */
public class JsonReaderTest {

    /**
     * / test non existent file
     */
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Home hm = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    /**
     * / test reader empty home file
     */

    @Test
    void testReaderEmptyHome() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyHome.json");
        try {
            Home hm = reader.read();
            assertEquals(0, hm.getListOfChores().getListOfChores().size());
            assertEquals(0, hm.getListOfMembers().getListOfMembers().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    /**
     * / test reader general Home file
     */

    @Test
    void testReaderGeneralHome() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralHome.json");
        try {
            Home hm = reader.read();
            assertEquals(2,hm.getListOfChores().getListOfChores().size());
            assertEquals(2,hm.getListOfMembers().getListOfMembers().size());
            assertEquals("arun",hm.getListOfMembers().getListOfMembers().get(0).getName());
            assertEquals("Dishes",hm.getListOfChores().getListOfChores().get(1).toString());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }





}
