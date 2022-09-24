package com.github.kinshuk;

import com.github.kinshuk.commands.cmdmng;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import com.github.kinshuk.listener.EventListener;

import javax.security.auth.login.LoginException;

public class TDS {
    private final Dotenv config;
    private final ShardManager shardManager;

    public TDS() throws LoginException {
        config = Dotenv.configure().load();
        String TOKEN = config.get("TOKEN");
        DefaultShardManagerBuilder Builder = DefaultShardManagerBuilder.createDefault(TOKEN);
        Builder.setActivity(Activity.playing("with your mom"));
        Builder.enableIntents(GatewayIntent.GUILD_MEMBERS , GatewayIntent.MESSAGE_CONTENT);
        shardManager = Builder.build();

        //calling listener
        shardManager.addEventListener(new EventListener(), new cmdmng());
    }

    public Dotenv getConfig(){
        return config;
    }

    public ShardManager getShardManager(){
        return shardManager;
    }
    public static void main(String[] args) {
        try{
            TDS bot = new TDS();
        } catch (LoginException e){
            System.out.println("ERROR: TOKEN INVALID");
        }
    }
}
