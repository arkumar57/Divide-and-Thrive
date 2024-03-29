package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.Collections;
import java.util.List;

/**
 * Represents allocation of list of chores to list of members.
 */
public class Home implements Writable {
    private ChoresList listOfChores;
    private MembersList listOfMembers;

    /**
     *listOfChores in Home is set to listOfChores
     *listOfMembers in Home is set to listOfMembers
     */
    public Home(ChoresList listOfChores,MembersList listOfMembers) {
        this.listOfChores = listOfChores;
        this.listOfMembers = listOfMembers;
    }

    public MembersList getListOfMembers() {
        EventLog.getInstance().logEvent(new Event("Display list of Members"));
        return listOfMembers;
    }

    public ChoresList getListOfChores() {
        EventLog.getInstance().logEvent(new Event("Display list of Chores"));
        return listOfChores;
    }

    public void addMember(Member member) {
        this.listOfMembers.addMember(member);
    }

    public void addChore(Chore chore) {
        this.listOfChores.addChore(chore);
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
            chore.setAssignedMember(member.getName());
            member.setAssignedChore(String.valueOf(chore));
        }

        EventLog.getInstance().logEvent(new Event("Chores Assigned to Members."));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listOfChores", listOfChoresToJson());
        json.put("listOfMembers", listOfMembersToJson());
        return json;
    }


    // EFFECTS: returns Members in this Home as a JSON array
    private JSONArray listOfMembersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Member t : listOfMembers.getListOfMembers()) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns Chores in this Home as a JSON array
    private JSONArray listOfChoresToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Chore t : listOfChores.getListOfChores()) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}
