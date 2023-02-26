package model;

import java.util.ArrayList;
import java.util.List;

public class ChoresList {
    private List<Chore> listOfChores = new ArrayList<>();

    public ChoresList() {
        this.listOfChores = listOfChores;
    }

    public void setListOfChores(List<Chore> listOfChores) {
        this.listOfChores = listOfChores;
    }

    public List<Chore> getListOfChores() {
        return listOfChores;
    }

    public void addChore(Chore a) {
        listOfChores.add(a);
    }

    public void removeChore(Chore r) {
        listOfChores.remove(r);
    }

}
