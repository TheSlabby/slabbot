package me.slabby.slabbot.commands;

import java.util.List;

import me.slabby.slabbot.CommandInterface;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Statistics implements CommandInterface {

    private SlashCommandInteractionEvent event;

    public Statistics(SlashCommandInteractionEvent event) {
        this.event = event;
    }

    @Override
    public String execute() {
        //get all messages
        MessageHistory history = MessageHistory.getHistoryFromBeginning(event.getChannel()).limit(100).complete();
        List<Message> mess = history.getRetrievedHistory();

        int testCount = 0;
        for (Message m : mess) {
            String msg = m.getContentRaw();
            if (msg.equals("test")) {
                testCount++;
            }
        }

        return "There are " + testCount + " tests in this channel.";

    }
    
}
