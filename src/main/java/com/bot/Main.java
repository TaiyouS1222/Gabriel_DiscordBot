package com.bot;

import com.bot.entities.Config;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static void main(String[] args){
        Config config = new Config();
        JDA jda = JDABuilder.createDefault(config.getToken()).build();
        JDABuilder builder = JDABuilder.createDefault(args[0]);
        builder.setActivity(Activity.playing("IntelliJ IDEA")).build();


    }
}
