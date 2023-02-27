package ui;

import model.*;
import model.Home;

import java.util.List;
import java.util.Scanner;

public class ChoresApp {
    private Scanner input;
    private ChoresList listOfChores;
    private MembersList listOfMembers;


    public ChoresApp() {
        runChore();

    }

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
        if (command.equals("a")) {
            addMembers();
        } else if (command.equals("l")) {
            printListOfMembers();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Assign Chores Randomly to Members");
        System.out.println("\tq -> quit");
        System.out.println("\tl -> get list of Members");
    }

    private void addMembers() {
        System.out.println("Enter No of Members in House: ");
        int quantity = input.nextInt();
        input.nextLine();

        if (quantity >= 2) {
            listOfMembers = new MembersList();
            for (int i = 1; i <= quantity; i++) {
                System.out.println("Enter name of house Member No" + i);
                String name = input.nextLine();
                Member member = new Member(name,null);
                listOfMembers.addMember(member);
            }
            addChores();
        } else {
            System.out.println("The Number of Member should be at least 2...\n");
        }
    }

    private void addChores() {
        listOfChores = new ChoresList();

        for (int i = 1; i <= listOfMembers.getListOfMembers().size(); i++) {
            System.out.println("Enter name of House Chore No:" + i);
            String name = input.nextLine();
            Chore chore = new Chore(name, null);
            listOfChores.addChore(chore);
        }
        assignment();
    }

    private void assignment() {
        Home home = new Home(listOfChores, listOfMembers);
        home.choresAssignment();
        for (Member member: listOfMembers.getListOfMembers()) {
            System.out.println(member.getName() + " has been assigned the Chore: " + member.getAssignedChore());
        }
    }

    private void printListOfMembers() {
        Home home = new Home(listOfChores,listOfMembers);
        List<Member> members = home.getListOfMembers().getListOfMembers();
        System.out.println("list of Members: ");
        for (Member member: members) {
            System.out.println(member.getName());
        }
    }

}


