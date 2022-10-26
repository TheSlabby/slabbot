package me.slabby.slabbot.listeners;

import java.util.Arrays;

import me.slabby.slabbot.commands.Roles;
import me.slabby.slabbot.commands.Statistics;
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

        if (message.charAt(0) == '!') {
            String[] args = message.substring(1).split(" ");
            String cmd = args[0];
            args = Arrays.copyOfRange(args, 1, args.length);
            if (cmd.equalsIgnoreCase("roles")) {
                new Roles(args, event).execute();
            } else if (cmd.equalsIgnoreCase("stats")) {
                new Statistics(args, event).execute();
            } else if (cmd.equalsIgnoreCase("ping")) {
                event.getChannel().sendMessage("Pong!").queue();
            }
        }

        if (message.toLowerCase().contains("kaleb")) {
            event.getMessage().addReaction(":sillykaleb:957501906022957087").queue();
        }
    }

}
