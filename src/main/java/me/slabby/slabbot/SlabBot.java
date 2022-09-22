package me.slabby.slabbot;

import java.util.ArrayList;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;
import me.slabby.slabbot.listeners.BotCommands;
import me.slabby.slabbot.listeners.EventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class SlabBot {

    private final Dotenv config;
    private final String token;

    public SlabBot() throws Exception {
        System.out.println("Instantiating SlabBot...");

        config = Dotenv.configure().load();
        token = config.get("TOKEN");


        
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.addEventListeners(new BotCommands());
        JDA jda = builder.build();
        jda.getPresence().setActivity(Activity.playing("Hello World!"));
        jda.getPresence().setStatus(OnlineStatus.ONLINE);

        //command data
        // List<CommandData> commands = new ArrayList<>();
        // commands.add(Commands.slash("stats", "Gets stats in channel"));
        // commands.add(Commands.slash("roles", "Lists the roles in the server"));
        // for (CommandData command : commands) {
        //     jda.upsertCommand(command);
        // }
        jda.upsertCommand("roles", "Gets the roles in the server");
        jda.upsertCommand("stats", "Gets the channel statistics");

        //event listeners
        jda.addEventListener(new EventListener(), new BotCommands());
    }

    public Dotenv getConfig() {
        return config;
    }

    public static void main(String[] args) {
        try {
            new SlabBot();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
