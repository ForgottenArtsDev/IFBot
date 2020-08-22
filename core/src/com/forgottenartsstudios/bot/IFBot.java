package com.forgottenartsstudios.bot;

import com.badlogic.gdx.ApplicationAdapter;
import com.forgottenartsstudios.commands.AddRole;
import com.forgottenartsstudios.commands.Clear;
import com.forgottenartsstudios.commands.Hello;
import com.forgottenartsstudios.commands.Poll;
import com.forgottenartsstudios.commands.RemoveRole;
import com.forgottenartsstudios.commands.Time;
import com.forgottenartsstudios.events.GuildMemberRemove;
import com.forgottenartsstudios.events.GuildMemberJoin;
import com.forgottenartsstudios.events.GuildMessageReactionAdd;
import com.forgottenartsstudios.events.GuildMessageReceived;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class IFBot extends ApplicationAdapter {
	//SpriteBatch batch;
	//Texture img;
	public static JDA jda;
	public static String prefix = "~";

	@Override
	public void create () {
		try {
			jda = new JDABuilder(AccountType.BOT).setToken("NzI1MDE5MjY4NTMzNDUyODYy.XvIo7w.gBXohcOrOkJ2gXthUtmogWdI2Qc").build();
			jda.getPresence().setStatus(OnlineStatus.ONLINE);
			jda.getPresence().setActivity(Activity.playing("iRobot"));

			jda.addEventListener(new Clear());
			jda.addEventListener(new Hello());
			jda.addEventListener(new Time());
			jda.addEventListener(new AddRole());
			jda.addEventListener(new RemoveRole());
			jda.addEventListener(new Poll());

			jda.addEventListener(new GuildMemberJoin());
			jda.addEventListener(new GuildMemberRemove());
			jda.addEventListener(new GuildMessageReceived());
			jda.addEventListener(new GuildMessageReactionAdd());

		} catch (LoginException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {

	}
}
