package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    private static JsonObject jsonObject;

    private static void loadJsonFile() {
        if (jsonObject == null) {
            try (FileReader reader = new FileReader("src/test/resources/testData.json")) {
                jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            } catch (IOException e) {
                throw new RuntimeException("Failed to load testData.json file: " + e.getMessage());
            }
        }
    }

    public static String getTestData(String key) {
        loadJsonFile();
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsString();
        } else {
            throw new IllegalArgumentException("Key '" + key + "' not found in testData.json");
        }
    }
}