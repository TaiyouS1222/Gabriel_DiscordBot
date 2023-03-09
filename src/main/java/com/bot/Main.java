package com.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static void main(String[] args){
        LoginInfo loginInfo = new LoginInfo();
        JDA jda = JDABuilder.createDefault(loginInfo.getToken()).build();
        JDABuilder builder = JDABuilder.createDefault(args[0]);
        builder.setActivity(Activity.playing("IntelliJ IDEA")).build();


    }
}
