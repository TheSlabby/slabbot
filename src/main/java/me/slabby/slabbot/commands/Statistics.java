package me.slabby.slabbot.commands;

import java.util.List;

import me.slabby.slabbot.CommandInterface;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Statistics implements CommandInterface {

    private MessageReceivedEvent event;
    private String[] args;

    public Statistics(String[] args, MessageReceivedEvent event) {
        this.args = args;
        this.event = event;
    }

    @Override
    public void execute() {
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

        //TODO say something

    }
    
}
