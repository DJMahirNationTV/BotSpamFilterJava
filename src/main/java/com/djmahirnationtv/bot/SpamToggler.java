package com.djmahirnationtv.bot;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class SpamToggler extends ListenerAdapter {
    private final SpamFilter spamfilter;

    public SpamToggler(SpamFilter spamfilter) {
        this.spamfilter = spamfilter;
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return; // Will Ignore the Bot Messages
        }
        String message = event.getMessage().getContentRaw(); // Gets Message in RAW format once again
        if (message.equalsIgnoreCase("/spam on")) {
            spamfilter.setSpamEnabled(true); // boolean is true which will enable the spam filter
            event.getChannel().sendMessage("Spam Filter has been Enabled!").queue();
        }
        else if (message.equalsIgnoreCase("/spam off")) {
            spamfilter.setSpamEnabled(false); // boolean is true which will disable the spam filter
            event.getChannel().sendMessage("Spam Filter has been Disabled!").queue();
        }
    }
}
