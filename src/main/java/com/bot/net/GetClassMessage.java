package com.bot.net;

import com.bot.entities.LoginInfo;

import java.net.HttpURLConnection;
import java.net.URL;

public class GetClassMessage {
    //Get message from Fudan Online
    LoginInfo loginInfo = new LoginInfo();
    private static final String URL = "http://netflow.fdhs.tyc.edu.tw/e-fdhs/login.php";
    public void getClassMessage() throws Exception{
        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        final String user_id = loginInfo.getUser_id();
        final String user_password = loginInfo.getUser_password();
    }
}
