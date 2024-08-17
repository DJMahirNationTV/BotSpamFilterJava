package com.djmahirnationtv.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.JDABuilder;


public class Main extends ListenerAdapter {
    public static void main(String[] args) throws Exception {
        String TOKEN = System.getenv("TOKEN");

        JDABuilder builder = JDABuilder.createDefault(TOKEN)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.GUILD_MESSAGES);

        SpamFilter spamFilter = new SpamFilter();
        SpamToggler spamToggler = new SpamToggler(spamFilter);

        builder.addEventListeners(spamFilter);
        builder.addEventListeners(spamToggler);

        JDA jda = builder.build();

        try {
            jda.awaitReady(); // Will wait until JDA is ready
            System.out.println("Ma Bro is ready boi!");
        } catch (InterruptedException e) {
            e.printStackTrace(); // print error
        }
    }
}