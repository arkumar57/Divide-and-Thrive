package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Represents allocation of list of chores to list of members.
 */
public class Home implements Writable {
    private final ChoresList listOfChores;
    private final MembersList listOfMembers;

    /**
     *listOfChores in Home is set to listOfChores
     *listOfMembers in Home is set to listOfMembers
     */
    public Home(ChoresList listOfChores,MembersList listOfMembers) {
        this.listOfChores = listOfChores;
        this.listOfMembers = listOfMembers;
    }

    public MembersList getListOfMembers() {
        return listOfMembers;
    }

    public ChoresList getListOfChores() {
        return listOfChores;
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
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listOfChores", listOfChoresToJson());
        json.put("listOfMembers", listOfMembersToJson());
        return json;
    }


    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray listOfMembersToJson() {
        JSONArray jsonArray = new JSONArray();
        Iterator var2 = this.listOfMembers.getListOfMembers().iterator();

        while (var2.hasNext()) {
            Member t = (Member) var2.next();
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray listOfChoresToJson() {
        JSONArray jsonArray = new JSONArray();
        Iterator var2 = this.listOfChores.getListOfChores().iterator();

        while (var2.hasNext()) {
            Chore t = (Chore) var2.next();
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}
