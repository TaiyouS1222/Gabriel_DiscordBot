package com.bot;

import org.jsoup.helper.HttpConnection;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetClassMessage {
    //Get message from Fudan Online
    private static final String URL = "http://netflow.fdhs.tyc.edu.tw/e-fdhs/login.php";
    public void getClassMessage() throws Exception{
        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    }
}
