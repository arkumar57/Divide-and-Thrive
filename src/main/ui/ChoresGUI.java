package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ChoresGUI extends JFrame implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton addMembers = new JButton("addMembers");
    private JButton addChores = new JButton("addChores");
    private JButton assignChores = new JButton("Assign Chores");
    private JButton listofmembers = new JButton("List Of Members");
    private JButton listofchores = new JButton("List Of Chores");
    private JButton saveData = new JButton("Save Data");
    private JButton loadData = new JButton("load Data");
    ImageIcon icon = new ImageIcon("./data/projectImage.jpg");
    JLabel label = new JLabel(icon);

    private static String JSON_STORE = "./data/home.json";
    private Scanner input;
    private ChoresList listOfChores = new ChoresList();
    private MembersList listOfMembers = new MembersList();
    private Home home = new Home(listOfChores, listOfMembers);
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    public ChoresGUI() {
        setButton();
        frameSet();
        this.jsonWriter = new JsonWriter("./data/home.json");
        this.jsonReader = new JsonReader("./data/home.json");

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                e.getWindow().dispose();
                Iterator<Event> eventIterator = EventLog.getInstance().iterator();
                while (eventIterator.hasNext()) {
                    System.out.println(eventIterator.next());
                }
                System.out.println("JFrame Closed!");
            }
        });
    }




    // MODIFIES: this
    // EFFECTS: sets the buttons
    public void setButton() {
        addMembers.setBounds(100,160,200,40);
        addMembers.setFocusable(false);
        addMembers.addActionListener(this);
        addChores.setBounds(100,220,200,40);
        addChores.setFocusable(false);
        addChores.addActionListener(this);
        assignChores.setBounds(100,280,200,40);
        assignChores.setFocusable(false);
        assignChores.addActionListener(this);
        listofmembers.setBounds(100,340,200,40);
        listofmembers.setFocusable(false);
        listofmembers.addActionListener(this);
        listofchores.setBounds(100,400,200,40);
        listofchores.setFocusable(false);
        listofchores.addActionListener(this);
        saveData.setBounds(100,460,200,40);
        saveData.setFocusable(false);
        saveData.addActionListener(this);
        loadData.setBounds(100,520,200,40);
        loadData.setFocusable(false);
        loadData.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: sets the frame structure
    public void frameSet() {
        frame.setContentPane(label);
        frame.add(addChores);
        frame.add(addMembers);
        frame.add(assignChores);
        frame.add(listofchores);
        frame.add(listofmembers);
        frame.add(saveData);
        frame.add(loadData);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,700);
        frame.setVisible(true);
        frame.repaint();
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveData) {
            saveHome();
        }
        if (e.getSource() == loadData) {
            loadHome();
        }
        if (e.getSource() == addMembers) {
            addMembers();
        }

        if (e.getSource() == addChores) {
            addChores();
        }

        if (e.getSource() == listofchores) {
            listOfChores();
        }

        if (e.getSource() == listofmembers) {
            listOfMembers();
        }

        if (e.getSource() == assignChores) {
            assignChores();
        }
    }

    // MODIFIES: this
    // EFFECTS: saves home to file

    private void saveHome() {
        try {
            this.jsonWriter.open();
            this.jsonWriter.write(this.home);
            this.jsonWriter.close();
            JOptionPane.showMessageDialog(this,"Saved " + this.home + " to ./data/home.json");
        } catch (FileNotFoundException var2) {
            System.out.println("Unable to write to file: ./data/home.json");
        }

    }

    // MODIFIES: this
    // EFFECTS: loads home from file
    private void loadHome() {
        try {
            jsonReader = new JsonReader(JSON_STORE);
            this.home = jsonReader.read();
            JOptionPane.showMessageDialog(this,"Loaded " + this.home + " from ./data/home.json");
        } catch (IOException var2) {
            System.out.println("Unable to read from file: ./data/home.json");
        }

    }

    // MODIFIES: this
    // EFFECTS: Adds Members to listOfMembers if quantity of Members >= 2 and calls addChores()
    private void addMembers() {
        String quantity = JOptionPane.showInputDialog(this, "Enter No of Members in House: ");
        int intQuantity = Integer.parseInt(quantity);

        if (intQuantity >= 2) {
            for (int i = 1; i <= intQuantity; i++) {
                String name = JOptionPane.showInputDialog(this, "Enter name of house Member No" + i);
                Member member = new Member(name,null);
                this.home.addMember(member);
            }
        } else {
            JOptionPane.showMessageDialog(this, "The Number of Member should be at least 2...");
        }
    }

    // MODIFIES: this
    // EFFECTS: add the chores to the listOfChores
    private void addChores() {
        int choresAdded = listOfChores.getListOfChores().size();
        int choresToAdd = home.getListOfMembers().getListOfMembers().size()
                - home.getListOfChores().getListOfChores().size();


        for (int i = 0; i < choresToAdd; i++) {
            String name =
                    JOptionPane.showInputDialog(this, "Enter name of House Chore No:" + (choresAdded + i + 1));

            Chore chore = new Chore(name, null);
            this.home.addChore(chore);
        }
    }

    // REQUIRES: listOfMembers is not empty
    // MODIFIES: this
    // EFFECTS: display listOfMembers
    private void listOfMembers() {
        List<Member> members = home.getListOfMembers().getListOfMembers();
        System.out.println("list of Members: ");
        List<String> myList = new ArrayList<>();
        for (Member member: members) {
            myList.add(member.getName());
        }
        String message = String.join(System.lineSeparator(), myList);
        JOptionPane.showMessageDialog(this, message);
    }

    // REQUIRES: listOfChores is not empty
    // MODIFIES: this
    // EFFECTS: display listOfChores
    private void listOfChores() {
        List<Chore> chores = home.getListOfChores().getListOfChores();
        System.out.println("list of Chores: ");
        List<String> myList = new ArrayList<>();
        for (Chore chore: chores) {
            myList.add(chore.toString());
        }
        String message = String.join(System.lineSeparator(), myList);
        JOptionPane.showMessageDialog(this,message);
    }

    // MODIFIES: this
    // EFFECTS: assign chores randomly to members
    private void assignChores() {
        home.choresAssignment();
        List<String> myList = new ArrayList<>();
        for (Member member: home.getListOfMembers().getListOfMembers()) {
            myList.add(member.getName() + " has been assigned the Chore: " + member.getAssignedChore());
        }
        String message = String.join(System.lineSeparator(), myList);
        JOptionPane.showMessageDialog(this, message);
    }




}
