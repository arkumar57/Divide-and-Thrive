package persistence;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * / test JSON writer
 */
public class JsonWriterTest {

    private ChoresList choresList;
    private MembersList membersList;

    @BeforeEach
    void runBefore() {
        choresList = new ChoresList();
        membersList = new MembersList();
    }



    /**
     * / test invalid file
     */
    @Test
    void testWriterInvalidFile() {

        try {
            Home hm = new Home(choresList,membersList);
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }


    /**
     * / Test Empty home file
     */
    @Test
    void testWriterEmptyHome() {
        try {
            Home hm = new Home(choresList,membersList);
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyHome.json");
            writer.open();
            writer.write(hm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyHome.json");
            hm = reader.read();
            assertEquals(0, hm.getListOfMembers().getListOfMembers().size());
            assertEquals(0,hm.getListOfChores().getListOfChores().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    /**
     * / test a general home file
     */

    @Test
    void testWriterGeneralHome() {
        try {
            Member kumar = new Member("kumar", "Washing");
            Member arun = new Member("arun", "Dishes");
            Chore Washing = new Chore("Washing", "arun");
            Chore Dishes = new Chore("Dishes", "kumar");
            Home home = new Home(choresList, membersList);
            home.getListOfChores().addChore(Washing);
            home.getListOfChores().addChore(Dishes);
            home.getListOfMembers().addMember(arun);
            home.getListOfMembers().addMember(kumar);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralHome.json");
            writer.open();
            writer.write(home);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralHome.json");
            home = reader.read();
            assertEquals(2, home.getListOfChores().getListOfChores().size());
            assertEquals(2, home.getListOfMembers().getListOfMembers().size());
            assertEquals("arun", home.getListOfMembers().getListOfMembers().get(0).getName());
            assertEquals("Dishes", home.getListOfChores().getListOfChores().get(1).toString());

        }catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }




}
