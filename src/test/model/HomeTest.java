package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Represents test for Home
 */
class HomeTest {

    @Test
    void testChoresAssignment() {
        ChoresList choresList1 = new ChoresList();
        MembersList membersList1 = new MembersList();
        MembersList membersList2 = new MembersList();
        Member kumar = new Member("kumar", "Washing");
        Member arun = new Member("arun", "Dishes");
        Chore Washing = new Chore("Washing", "arun");
        Chore Dishes = new Chore("Dishes", "kumar");
        Home home = new Home(choresList1, membersList1);
        home.getListOfChores().addChore(Washing);
        home.getListOfChores().addChore(Dishes);
        home.getListOfMembers().addMember(arun);
        home.getListOfMembers().addMember(kumar);
        home.choresAssignment();

        for (Chore chore: home.getListOfChores().getListOfChores()) {
            assertNotNull(chore.getAssignedMember());
        }
        for (Member member: home.getListOfMembers().getListOfMembers()) {
            assertNotNull(member.getAssignedChore());
        }

    }
}
