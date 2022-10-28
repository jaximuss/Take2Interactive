package GamersHub.ng;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class TakeIt {

    private final Dotenv config;
    private final ShardManager shardManager;

    public TakeIt()
    {
        config = Dotenv.configure().load();

        //lets get put token from config
            String token =    config.get("TOKEN");
        //this is like an event hanlder in c#
        DefaultShardManagerBuilder Builder = DefaultShardManagerBuilder.createDefault(token);
        Builder.setStatus(OnlineStatus.ONLINE);
        Builder.setActivity(Activity.playing("deez nutz??"));
        //this one is for the commands
        Builder.addEventListeners(commandHandler);
        shardManager =  Builder.build();

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