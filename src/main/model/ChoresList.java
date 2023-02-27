package model;

import java.util.ArrayList;
import java.util.List;

public class ChoresList {
    private final List<Chore> listOfChores = new ArrayList<>();

    public List<Chore> getListOfChores() {
        return listOfChores;
    }

    //Modifies:this
    //Effects:Adds chores to the Arraylist of chores.

    public void addChore(Chore a) {
        listOfChores.add(a);
    }
}

