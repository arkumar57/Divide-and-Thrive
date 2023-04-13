package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of Chores.
 */
public class ChoresList {
    private final List<Chore> listOfChores = new ArrayList<>();

    public List<Chore> getListOfChores() {
        return listOfChores;
    }

    //Modifies:this
    //Effects:Adds chores to the Arraylist of chores.

    public void addChore(Chore a) {
        listOfChores.add(a);
        EventLog.getInstance().logEvent(new Event("Chores Added to list."));
    }
}

