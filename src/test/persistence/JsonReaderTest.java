package persistence;

import model.Home;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{

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

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyHome.json");
        try {
            Home hm = reader.read();
            assertEquals(0, hm.getListOfChores().getListOfChores().size());
            assertEquals(0, hm.getListOfMembers().getListOfMembers().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }






}
