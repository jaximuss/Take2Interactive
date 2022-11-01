package GamersHub.ng;

import GamersHub.ng.listerners.eventHandler;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import java.util.EventListener;

public class TakeIt {

    private final Dotenv config;




    //always ask the shardmanager to add things for you
    private final ShardManager shardManager;

    public TakeIt()
    {
        config = Dotenv.configure().load();

        //lets get put token from config
        String token =    config.get("TOKEN");
        //this is like an event handle in c#
        DefaultShardManagerBuilder Builder = DefaultShardManagerBuilder.createDefault(token);
        Builder.setStatus(OnlineStatus.ONLINE);
        Builder.setActivity(Activity.playing("thinking about deez nutz??"));
        Builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        Builder.enableIntents(GatewayIntent.GUILD_MESSAGES);

        //this one is for the commands
        // Builder.addEventListeners(commandHandler);
        shardManager =  Builder.build();
        //event listeners
        //the shardManager will be responsible for adding things
       shardManager.addEventListener(new eventHandler());
    }




    public ShardManager getShardManager() {
        return shardManager;
    }

    public Dotenv getConfig() {
            return config;
    }

    public static void main(String[] args)
    {
            TakeIt takeIt = new TakeIt();
    }
}