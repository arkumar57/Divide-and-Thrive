package model;

import java.util.Collections;
import java.util.List;

/**
 * Represents allocation of list of chores to list of members.
 */
public class Home {
    private final ChoresList listOfChores;
    private final MembersList listOfMembers;

    /**
     *listOfChores in Home is set to listOfChores
     *listOfMembers in Home is set to listOfMembers
     */
    public Home(ChoresList listOfChores,MembersList listOfMembers) {
        this.listOfChores = listOfChores;
        this.listOfMembers = listOfMembers;
    }

    public MembersList getListOfMembers() {
        return listOfMembers;
    }

    public ChoresList getListOfChores() {
        return listOfChores;
    }

    //Modifies:this,chore,member
    //Effects:Shuffles the chores in the Arraylist of Chores and assigns randomly to members in the arraylist of Members
    public void choresAssignment() {
        List<Chore> chores = listOfChores.getListOfChores();
        List<Member> members = listOfMembers.getListOfMembers();

        Collections.shuffle(chores);

        for (int i = 0;i < chores.size(); i++) {
            Chore chore = chores.get(i);
            Member member = members.get(i);
            chore.setAssignedMember(String.valueOf(member));
            member.setAssignedChore(String.valueOf(chore));
        }
    }
}
