package me.slabby.slabbot.commands;

import me.slabby.slabbot.CommandInterface;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Roles implements CommandInterface {

    private SlashCommandInteractionEvent event;

    public Roles (SlashCommandInteractionEvent event) {
        this.event = event;
    }

    @Override
    public String execute() {
        String response = "**Roles:**\n";
        for (Role role : event.getJDA().getRoles()) {
            response += role.getAsMention() + "\n";
        }

        return response;
    }
    
}
