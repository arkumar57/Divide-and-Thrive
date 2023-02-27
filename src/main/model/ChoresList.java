package model;

import java.util.ArrayList;
import java.util.List;

public class ChoresList {
    private List<Chore> listOfChores = new ArrayList<>();

    public ChoresList() {
        this.listOfChores = listOfChores;
    }


    public List<Chore> getListOfChores() {
        return listOfChores;
    }

    //Modifies:this
    //Effects:Adds chores to the Arraylist of chores.

    public void addChore(Chore a) {
        listOfChores.add(a);
    }
}

