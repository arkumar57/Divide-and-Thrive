package persistence;

import org.json.JSONObject;

/**
 * / returns JSON object
 */
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}

