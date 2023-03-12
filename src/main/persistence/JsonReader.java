package persistence;


import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Home read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseHome(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private Home parseHome(JSONObject jsonObject) {
        ChoresList c = new ChoresList();
        MembersList m = new MembersList();

        addChores(c, jsonObject);
        addMembers(m, jsonObject);
        Home hm = new Home(c, m);
        return hm;
    }

    private void addMembers(MembersList m, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("listOfMembers");
        for (Object json : jsonArray) {
            JSONObject nextMember = (JSONObject) json;
            String memberName = nextMember.getString("name");
            String as = nextMember.getString("assignedChore");
            Member member = new Member(memberName, as);
            m.addMember(member);
        }
    }

    private void addChores(ChoresList c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("listOfChores");
        for (Object json : jsonArray) {
            JSONObject nextChore = (JSONObject) json;
            String choreName = nextChore.getString("name");
            String ac = nextChore.getString("assignedMember");
            Chore chore = new Chore(choreName, ac);
            c.addChore(chore);
        }
    }


}

