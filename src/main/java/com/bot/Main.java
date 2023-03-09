package com.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static void main(String[] args){
        String token = "OTk5OTcyMzE0ODI3NDcyOTU3.GAxm_N.SMKJZMVVo_9A5514KaFGgG4Srr4wsrcuFESD3Q";
        JDA jda = JDABuilder.createDefault(token).build();
        JDABuilder builder = JDABuilder.createDefault(args[0]);
        builder.setActivity(Activity.playing("IntelliJ IDEA")).build();


    }
}
