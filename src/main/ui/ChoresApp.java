package ui;

import model.*;
import model.Home;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a user interface for Chores App.
 */
public class ChoresApp {
    private static final String JSON_STORE = "./data/home.json";
    private Scanner input;
    private ChoresList listOfChores = new ChoresList();
    private MembersList listOfMembers = new MembersList();
    private Home home = new Home(listOfChores,listOfMembers);
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    /**
     * Calls runChore.
     */
    public ChoresApp() {
        this.jsonWriter = new JsonWriter("./data/home.json");
        this.jsonReader = new JsonReader("./data/home.json");
        runChore();

    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runChore() {
        boolean keepGoing = true;
        String command;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("m")) {
            addMembers();
        } else if (command.equals("c")) {
            addChores();
        } else if (command.equals("a")) {
            assignment();
        } else if (command.equals("i")) {
            printListOfChores();
        } else if (command.equals("l")) {
            printListOfMembers();
        } else if (command.equals("s")) {
            saveHome();
        } else if (command.equals("f")) {
            loadHome();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes ChoresApp
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tm -> add Members");
        System.out.println("\tc -> add Chores");
        System.out.println("\ta -> Assign Chores Randomly to Members");
        System.out.println("\tl -> get list of Members");
        System.out.println("\ti -> get list of Chores for Members");
        System.out.println("\ts -> save home to file");
        System.out.println("\tf -> load home from file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: Adds Members to listOfMembers if quantity of Members >= 2 and calls addChores()
    private void addMembers() {
        System.out.println("Enter No of Members in House: ");
        int quantity = input.nextInt();
        input.nextLine();

        if (quantity >= 2) {
            for (int i = 1; i <= quantity; i++) {
                System.out.println("Enter name of house Member No" + i);
                String name = input.nextLine();
                Member member = new Member(name,null);
                listOfMembers.addMember(member);
            }
        } else {
            System.out.println("The Number of Member should be at least 2...\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: add the chores to the listOfChores
    private void addChores() {

        int choresAdded = listOfChores.getListOfChores().size();
        int choresToAdd = listOfMembers.getListOfMembers().size() - listOfChores.getListOfChores().size();

        for (int i = 0; i < choresToAdd; i++) {
            System.out.println("Enter name of House Chore No:" + (choresAdded + i + 1));
            String name = input.next();
            Chore chore = new Chore(name, null);
            listOfChores.addChore(chore);
        }
    }

    // MODIFIES: this
    // EFFECTS: assign chores randomly to members
    private void assignment() {
        home.choresAssignment();
        for (Member member: home.getListOfMembers().getListOfMembers()) {
            System.out.println(member.getName() + " has been assigned the Chore: " + member.getAssignedChore());
        }
    }

    // REQUIRES: listOfMembers is not empty
    // MODIFIES: this
    // EFFECTS: print listOfMembers
    private void printListOfMembers() {
        List<Member> members = home.getListOfMembers().getListOfMembers();
        System.out.println("list of Members: ");
        for (Member member: members) {
            System.out.println(member.getName());
        }
    }

    // REQUIRES: listOfChores is not empty
    // MODIFIES: this
    // EFFECTS: print listOfChores
    private void printListOfChores() {
        List<Chore> chores = home.getListOfChores().getListOfChores();
        System.out.println("list of Chores: ");
        for (Chore chore: chores) {
            System.out.println(chore.toString());
        }
    }

    // EFFECTS: saves the home to file
    private void saveHome() {
        try {
            this.jsonWriter.open();
            this.jsonWriter.write(this.home);
            this.jsonWriter.close();
            System.out.println("Saved " + this.home + " to ./data/home.json");
        } catch (FileNotFoundException var2) {
            System.out.println("Unable to write to file: ./data/home.json");
        }

    }

    // MODIFIES: this
    // EFFECTS: loads home from file
    private void loadHome() {
        try {
            this.home = this.jsonReader.read();
            System.out.println("Loaded " + this.home + " from ./data/home.json");
        } catch (IOException var2) {
            System.out.println("Unable to read from file: ./data/home.json");
        }

    }

}


