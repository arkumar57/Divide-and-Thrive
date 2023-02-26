package model;

import java.util.ArrayList;
import java.util.List;

public class Chore {
    private String name;
    private String assignedMember;

    // name is the task which A member of Home performs

    private List<Chore> listOfChores = new ArrayList<>();

    public Chore(String name, String assignedMember) {
        this.name = name;
        this.assignedMember = assignedMember;

    }



    public String getAssignedMember() {
        return assignedMember;
    }

    public void setAssignedMember(String assignedMember) {
        this.assignedMember = assignedMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}
