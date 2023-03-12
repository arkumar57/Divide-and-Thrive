package persistence;

import model.ChoresList;
import model.Home;
import model.MembersList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    private ChoresList choresList;
    private MembersList membersList;


    @Test
    void testWriterInvalidFile() {
        choresList = new ChoresList();
        membersList = new MembersList();

        try {
            Home hm = new Home(choresList,membersList);
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }











}
