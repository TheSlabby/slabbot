package me.slabby.slabbot.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {
    
    public EventListener() {
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("Message received!");
        if (event.getAuthor().isBot()) {
            return;
        }

        String message = event.getMessage().getContentRaw();
        if (message.equalsIgnoreCase("ping")) {
            event.getChannel().sendMessage("pong").queue();
        }
    }

}
