package com.bot;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class GetToken {
    private String token;
    public String getToken(){
        JSONParser jsonParser = new JSONParser();
        Object ob = null;
        try {
            ob = jsonParser.parse(new FileReader("C:\\IdeaProjects\\Gabriel_DiscordBot\\token.json"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        JSONObject jsonObject = (JSONObject) ob;
        token = (String) jsonObject.get("token");
        return token;
    }

}
