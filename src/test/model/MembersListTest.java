package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Represents test for MemberList
 */
public class MembersListTest {

    private MembersList membersList1;
    private MembersList membersList2;

    @BeforeEach
    void runBefore(){
        membersList1 = new MembersList();
        membersList2 = new MembersList();
        new Chore("Washing", "arun");

    }
    @Test
    void testAddMember(){
        Member arun = new Member("arun","Washing");
        membersList1.addMember(arun);
        assertEquals(1, membersList1.getListOfMembers().size());
        assertEquals(arun, membersList1.getListOfMembers().get(0));
        assertEquals(0, membersList2.getListOfMembers().size());
        assertTrue(membersList2.getListOfMembers().isEmpty());
    }
}
