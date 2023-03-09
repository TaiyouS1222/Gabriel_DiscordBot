

import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.json.simple.*;

import java.io.FileReader;
import java.io.IOException;


public class TestGetToken {
    @Test
    public void testGetToken() throws Exception {
        JSONParser jsonParser = new JSONParser();
        Object ob = jsonParser.parse(new FileReader("C:\\IdeaProjects\\Gabriel_DiscordBot\\token.json"));
        JSONObject jsonObject = (JSONObject) ob;
        String token = (String) jsonObject.get("token");
        System.out.println(token);
    }
}
