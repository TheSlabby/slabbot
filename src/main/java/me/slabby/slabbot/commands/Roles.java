package me.slabby.slabbot.commands;

import me.slabby.slabbot.CommandInterface;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Roles implements CommandInterface {

    private MessageReceivedEvent event;
    private String[] args;

    public Roles (String[] args, MessageReceivedEvent event) {
        this.args = args;
        this.event = event;
    }

    @Override
    public void execute() {
        String response = "**Roles:**\n";
        for (Role role : event.getJDA().getRoles()) {
            response += role.getAsMention() + "\n";
        }

        event.getChannel().sendMessage(response).queue();
    }
    
}
