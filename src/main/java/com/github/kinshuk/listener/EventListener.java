package com.github.kinshuk.listener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static java.awt.Color.blue;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (message.contains("ping")){
            event.getChannel().sendMessage("pong").queue();
        }
        if (message.contains("info")){
            EmbedBuilder info = new EmbedBuilder();
//            event.getChannel().sendMessageEmbeds info.setTitle("Information"),
//                                         info.setDescription("its a truth and dare bot but we will add some more intresting things soon"),
//                                         info.addField("Father", "Kinshuk",false),
//                                         info.setColor(blue)).queue();
//             event.getChannel().sendTyping().queue()
//            event.getChannel().sendMessage("noice").queue();
//            event.getChannel().sendMessage("pong").queue();
        }
    }
}
