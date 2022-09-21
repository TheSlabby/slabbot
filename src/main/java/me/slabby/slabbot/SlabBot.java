package me.slabby.slabbot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

public class SlabBot {

    private final Dotenv config;
    private final String token;

    public SlabBot() throws Exception {
        System.out.println("Instantiating SlabBot...");

        config = Dotenv.configure().load();
        token = config.get("TOKEN");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("with your mom"));

        builder.build();
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
