package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String assignedChore;

    private List<Member> listOfMembers = new ArrayList<>();

    public Member(String name,String assignedChore) {
        this.name = name;
        this.assignedChore = assignedChore;
    }

    public String getAssignedChore() {
        return assignedChore;
    }

    public void setAssignedChore(String assignedChore) {
        this.assignedChore = assignedChore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}

