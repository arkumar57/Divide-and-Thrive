package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MemberTest {
    private Member member;

    @BeforeEach
    void runBefore(){
        member = new Member("Arun",null);
    }
    @Test
    void testMember(){
        assertEquals("Arun",member.getName());
        assertNull(member.getAssignedChore());
    }
}
