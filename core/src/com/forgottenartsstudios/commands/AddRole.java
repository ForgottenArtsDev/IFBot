package com.forgottenartsstudios.commands;

import com.forgottenartsstudios.bot.IFBot;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AddRole extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s");

        if (args[0].equalsIgnoreCase(IFBot.prefix + "role")) {
            if (args[1].equalsIgnoreCase("add")) {
                if(args.length < 3) {
                    event.getChannel().sendMessage("Not enough args").queue();
                }
                else {
                    Role role = event.getGuild().getRolesByName(args[2], true).get(0);
                    Member member = event.getGuild().getMemberById(args[3]);
                    event.getGuild().addRoleToMember(member, role).complete();
                    event.getChannel().sendMessage("Role " + args[2] + " added to " + member.getEffectiveName()).queue();
                }
            }
        }
    }
}
