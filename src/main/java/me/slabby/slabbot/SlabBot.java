package me.slabby.slabbot;

import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

public class SlabBot {
    
    public static final String TOKEN = "token";

    public SlabBot() {
        
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(TOKEN);
    }
    public static void main(String[] args) {
        
    }
}
