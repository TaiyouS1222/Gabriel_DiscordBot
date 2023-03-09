import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TestGetClassMessage{
    private static final String URL = "http://netflow.fdhs.tyc.edu.tw/e-fdhs/login.php";
    @Test
    public void getClassMessage() throws Exception{
        java.net.URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        String test = new Scanner(url.openStream()).useDelimiter("\\A").next();
        System.out.println(test);
    }
}

