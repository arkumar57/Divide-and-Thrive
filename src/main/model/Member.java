package model;

import org.json.JSONObject;
import persistence.Writable;

/**
 * Represents a Member
 */
public class Member implements Writable {
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("assignedChore", assignedChore);
        return json;
    }


}

