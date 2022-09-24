package com.github.kinshuk.commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class cmdmng extends ListenerAdapter {

    String[] question;

    {

        question = new String[]{ "Q.What's the last lie you told?",
                 "Q.Name someone you've pretended to like but actually couldn't stand",
                 "Q.who are you most jealous of ?",
                 "Q.How do you really feel about the Twilight saga?",
                 "Q.When's the last time you apologized? What for?",
                 "Q.Would you date your high school crush today?",
                 "Q.What's your least favourite memory of from college (in details)",
                 "Q.What's your guilty pleasure song?",
                 "Q.Do you have any hidden talents? What are they?",
                 "Q.What is the last thing you searched for on you phone?(share screenshot of your history)",
                 "Q.Have you ever walked in your parents doing it?",
                 "Q.What color underwear are you wearing rigth now?",
                 "Q.Have you ever tasted ear wax?",
                 "Q.What is the most illegal thing you have ever done?",
                 "Q.When was the last time you wet the bed?",
                 "Q.Do you have bad foot odor?",
                 "Q.Have you ever practiced kissing in a mirror?",
                 "Q.Why did your last relationship end?",
                 "Q.What's the best advice you've ever been given?",
                 "Q.When was the last time you cried?",
                 "Q.What's your biggest insecurity?",
                 "Q.What is your hottest sexual fantasy?",
                 "Q.Has anyone ever walked in on you in the bathroom?",
                 "Q.Have you ever sent a nude photo?",
                 "Q.What is the most embarrassing thing you've posted on social media?",
        };
    }

    String[] dareque = { "Let another person post an Instagram caption on your behalf.",
             "Talk in a British accent until your next turn.",
             "Bark like a dog until it’s your next turn.",
             "Reveal your screen time report to your friends.",
             "Pick someone in this room and (lovingly) roast them for one minute straight.",
             "Read the last text message you sent out loud.",
             "Make an animal sound",
             "Text a random person and write ‘I see dead people.",
             "Show everyone your Google history.",
             "Show a picture of your first crush.",
             "Write a short love poem",
             "Write a break-up text message and send it to someone random in your contacts.(Take a screenshot for proof)",
             "Take 5 minutes and write a love poem to the prettiest person in your group according to you.",
             "Write my name on your chest and send the picture",
             "Explain exactly what turns you on about your favorite body part.",
    };

    Random random = new Random();


    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if(command.equals("ping")){
            event.reply("pong").queue();
        }
        if(command.equals("truth")){
            int randomnumber = random.nextInt(25)+1;
            event.reply(question[randomnumber]).queue();
        }
        if(command.equals("dare")){
            int randomnumber = random.nextInt(14)+1;
            event.reply(dareque[randomnumber]).queue();
        }
        if(command.equals("start")){
            event.reply("Type ``/truth`` for truth."+'\n'+"Type ``/dare`` for dare.").queue();
        }
    }




    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("sup","greetings"));
        commandData.add(Commands.slash("truth","question to ask"));
        commandData.add(Commands.slash("dare","dare to do"));
        commandData.add(Commands.slash("start","To start Truth and dare"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
