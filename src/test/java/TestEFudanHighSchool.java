import com.bot.entities.Config;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class TestEFudanHighSchool {
    public static void main(String[] args) {
        Config config = new Config();
        String loginUrl = "http://netflow.fdhs.tyc.edu.tw/e-fdhs/login.php";
        String user_id = config.getUserId();
        String user_password = config.getUserPassword();

        try {
            // 创建HttpClient
            HttpClient client = HttpClientBuilder.create().build();

            // 创建CookieStore
            CookieStore cookieStore = new BasicCookieStore();

            // 创建POST请求，并设置表单数据
            HttpPost post = new HttpPost(loginUrl);
            List<NameValuePair> formParams = new ArrayList<>();
            formParams.add(new BasicNameValuePair("user_id", user_id));
            formParams.add(new BasicNameValuePair("user_password", user_password));
            formParams.add(new BasicNameValuePair("submit", "Submit"));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
            post.setEntity(entity);

            // 执行POST请求，并获取响应
            HttpResponse response = client.execute(post);
            HttpEntity responseEntity = response.getEntity();

            // 检查响应状态码
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            if (statusCode == 200) {
                // 将cookie存储到CookieStore中
                String cookieValue = response.getFirstHeader("Set-Cookie").getValue();
                String[] parts = cookieValue.split(";");
                String cookieName = parts[0].split("=")[0];
                String cookieContent = parts[0].split("=")[1];
                BasicClientCookie cookie = new BasicClientCookie(cookieName, cookieContent);
                cookie.setDomain("netflow.fdhs.tyc.edu.tw");
                cookie.setPath("/");
                cookieStore.addCookie(cookie);

                System.out.println(cookieValue);

                // 创建HttpClientContext，并设置CookieStore
                HttpClientContext context = HttpClientContext.create();
                context.setCookieStore(cookieStore);

                // 创建GET请求，并设置Cookie
                HttpGet get = new HttpGet("http://netflow.fdhs.tyc.edu.tw/e-fdhs/main.php");
                context.setCookieStore(cookieStore);

                // 执行GET请求，并获取响应
                response = client.execute(get, context);
                responseEntity = response.getEntity();

                // 获取响应内容
                String content = EntityUtils.toString(responseEntity);
                System.out.println(content);
            } else {
                System.out.println("登录失败：" + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
