package me.slabby.slabbot.listeners;

import me.slabby.slabbot.commands.Statistics;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotCommands extends ListenerAdapter {
    
    public BotCommands() {
        System.out.println("Instantiating BotCommands...");
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("stats")) {
            event.reply(new Statistics(event).execute()).queue();
        }
    }
}
