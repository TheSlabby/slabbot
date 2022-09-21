package me.slabby.slabbot;

import io.github.cdimascio.dotenv.Dotenv;
import me.slabby.slabbot.listeners.BotCommands;
import me.slabby.slabbot.listeners.EventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

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
        jda.upsertCommand("stats", "Get stats in channel").queue();

        jda.addEventListener(new EventListener());
        jda.addEventListener(new BotCommands());
    }

    public Dotenv getConfig() {
        return config;
    }

    public static void main(String[] args) {
        try {
            SlabBot bot = new SlabBot();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
