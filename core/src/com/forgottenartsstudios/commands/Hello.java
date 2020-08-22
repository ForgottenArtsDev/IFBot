package com.forgottenartsstudios.commands;

import com.forgottenartsstudios.bot.IFBot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Hello extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s");

        if (args[0].equalsIgnoreCase(IFBot.prefix + "hello")) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Hello " + event.getMessage().getAuthor().getAsMention() + "!").queue();
        }
    }
}
