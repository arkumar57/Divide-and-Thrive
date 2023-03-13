package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of members
 */
public class MembersList {

    private List<Member> listOfMembers = new ArrayList<>();



    public List<Member> getListOfMembers() {
        return listOfMembers;
    }


    //Modifies:this
    //Effects:add members to the ArrayList of Members.
    public void addMember(Member a) {
        listOfMembers.add(a);
    }
}
