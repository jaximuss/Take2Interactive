package GamersHub.ng.listerners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.nio.channels.Channel;

//cntrl+o to manipulate alot of methods and events
public class eventHandler extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        String user = event.getUser().getName().toUpperCase();
        String emoji  = event.getReaction().getEmoji().getAsReactionCode();

        //mention is that thing that makes u jump to a channel when tap or clicked on
        String mentionedChannelName = event.getChannel().getAsMention();
        //we are doing the same here to get the source of the reaction and go directly to the message
        String jumpLink = event.getJumpUrl();

        String messageTheUser = user + "reacted to a message with " + emoji+ " in the channel";
        event.getGuildChannel().sendMessage(messageTheUser).queue();


    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {

        boolean isItABot = event.getAuthor().isBot();
        String userName = event.getAuthor().getName();
        if (isItABot== true)
        {

        }else {
            String channel = event.getChannel().getAsMention();
            String Message = userName + " just sent a message to" + channel + " channel";
            event.getGuildChannel().sendMessage(Message).queue();
        }
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        String userName = event.getUser().getName();
        String picture = event.getUser().getAvatarUrl();
        String Message = userName + " just joined the server"+ picture;
        event.getGuild().



    }
}