package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class HomeTest {
    private ChoresList choresList1;
    private ChoresList choresList2;
    private MembersList membersList1;
    private MembersList membersList2;
    private Home home;

    @Test
    void testChoresAssignment() {
        choresList1 = new ChoresList();
        choresList2 = new ChoresList();
        membersList1 = new MembersList();
        membersList2 = new MembersList();
        Member kumar = new Member("kumar", "Washing");
        Member arun = new Member("arun", "Dishes");
        Chore Washing = new Chore("Washing", "arun");
        Chore Dishes = new Chore("Dishes", "kumar");
        home = new Home(choresList1, membersList1);
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
