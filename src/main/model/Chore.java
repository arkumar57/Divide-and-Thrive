package model;

/**
 * / represents a Chore
 */
public class Chore {
    private final String name;
    private String assignedMember;

    // name is the task which A member of Home performs

    /**
     *name of Chore is set to its name
     *assignedMember of Chore is set to assignedMember
     */
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

    @Override
    public String toString() {
        return name;
    }

}
