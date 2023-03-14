package com.bot.entities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Config {
    private String token;
    private String user_id;
    private String user_password;
    JSONParser jsonParser = new JSONParser();
    Object ob;
    {
        try {
            ob = jsonParser.parse(new FileReader("C:\\IdeaProjects\\Gabriel_DiscordBot\\Config.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    JSONObject jsonObject = (JSONObject) ob;
    public String getToken(){
        token = (String) jsonObject.get("token");
        return token;
    }
    public String getUser_id(){
        user_id = (String) jsonObject.get("user_id");
        return user_id;
    }
    public String getUser_password(){
        user_password = (String) jsonObject.get("user_password");
        return user_password;
    }

}
