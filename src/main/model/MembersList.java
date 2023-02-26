package model;

import java.util.ArrayList;
import java.util.List;

public class MembersList {

    private List<Member> listOfMembers = new ArrayList<>();

    public MembersList() {
        this.listOfMembers = listOfMembers;
    }

    public List<Member> getListOfMembers() {
        return listOfMembers;
    }

    public void setListOfMembers(List<Member> listOfMembers) {
        this.listOfMembers = listOfMembers;
    }

    public void addMember(Member a) {
        listOfMembers.add(a);
    }

    public void removeMember(Member r) {
        listOfMembers.remove(r);
    }
}
