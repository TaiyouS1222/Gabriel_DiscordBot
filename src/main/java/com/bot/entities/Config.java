package com.bot.entities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Config {
    private final String token;
    private final String userId;
    private final String userPassword;
    public Config() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("C:\\IdeaProjects\\Gabriel_DiscordBot\\Config.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            token = (String) jsonObject.get("token");
            userId = (String) jsonObject.get("user_id");
            userPassword = (String) jsonObject.get("user_password");
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Failed to read configuration file.", e);
        }
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
