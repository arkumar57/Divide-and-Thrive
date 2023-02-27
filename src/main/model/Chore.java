package model;


public class Chore {
    private final String name;
    private String assignedMember;

    // name is the task which A member of Home performs


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



    public String toString() {
        return name;
    }

}
