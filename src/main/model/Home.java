package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Home {
    private ChoresList listOfChores;
    private MembersList listOfMembers;

    public Home(ChoresList listOfChores,MembersList listOfMembers) {
        this.listOfChores = listOfChores;
        this.listOfMembers = listOfMembers;
    }


    public void setListOfMembers(MembersList listOfMembers) {
        this.listOfMembers = listOfMembers;
    }

    public void setListOfChores(ChoresList listOfChores) {
        this.listOfChores = listOfChores;
    }


    public ChoresList getListOfChores() {
        return listOfChores;
    }

    public MembersList getListOfMembers() {
        return listOfMembers;
    }


    public void choresAssignment() {
        List<Chore> chores = listOfChores.getListOfChores();
        List<Member> members = listOfMembers.getListOfMembers();

        Collections.shuffle(chores);
        Collections.shuffle(members);

        for (int i = 0;i < chores.size(); i++) {
            Chore chore = chores.get(i);
            Member member = members.get(i);
            chore.setAssignedMember(String.valueOf(member));
            member.setAssignedChore(String.valueOf(chore));
        }
    }

}
