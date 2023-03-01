package model;

/**
 * Represents a Member
 */
public class Member {
    private final String name;
    private String assignedChore;

    /**
     *Name of Member is set to its name.
     *assignedChore to Member is set to assignedChore.
     */
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







}

