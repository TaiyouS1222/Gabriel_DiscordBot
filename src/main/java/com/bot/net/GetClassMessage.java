package com.bot.net;

import com.bot.entities.Config;

import java.net.HttpURLConnection;
import java.net.URL;

public class GetClassMessage {
    //Get message from Fudan Online
    Config config = new Config();
    private static final String URL = "http://netflow.fdhs.tyc.edu.tw/e-fdhs/login.php";
    public void getClassMessage() throws Exception{
        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        final String user_id = config.getUser_id();
        final String user_password = config.getUser_password();
    }
}
