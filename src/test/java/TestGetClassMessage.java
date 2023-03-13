import com.bot.entities.LoginInfo;
import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TestGetClassMessage{
    LoginInfo loginInfo = new LoginInfo();
    private String user_id = loginInfo.getUser_id();
    private String user_password = loginInfo.getUser_password();
    @Test
    public void getClassMessage() throws Exception{
        URL url = new URL("http://netflow.fdhs.tyc.edu.tw/e-fdhs/login.php");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=Big-5");
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");


        String data = "user_id="+user_id+"&user_password="+user_password+"&submit=Submit";
        OutputStream os = conn.getOutputStream();
        os.write(data.getBytes());
        os.flush();
        os.close();

        String cookie = conn.getHeaderField("Set-Cookie");

        url = new URL("http://netflow.fdhs.tyc.edu.tw/e-fdhs/login.php");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Cookie", cookie);
        conn.setRequestProperty("Accept-charset", "Big-5");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        String dataToScope = parseHTML(content.toString());

        System.out.println(dataToScope);
    }
    private static String parseHTML(String html){
        String data = Jsoup.parse(html).html();

        return data;
    }
}

