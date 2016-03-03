package me.dominator.blizzardcore;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.MessageRequest;
import me.dominator.blizzardcore.Commands.AlertCommand;
import me.dominator.blizzardcore.Commands.DispatchCommand;
import me.dominator.blizzardcore.Commands.StaffChatCommand;
import me.dominator.blizzardcore.Listeners.LilyListener;

public class Main extends JavaPlugin {
	
	public FileConfiguration config;
	File cfile;
	
	public void onEnable(){
		config = getConfig();
		config.options().copyDefaults(true);
		cfile = new File(getDataFolder(), "config.yml");
		saveConfig();
		getCommand("alert").setExecutor(new AlertCommand(this));
		getCommand("dispatch").setExecutor(new DispatchCommand(this));
		getCommand("a").setExecutor(new StaffChatCommand(this));
		getBukkitConnect().registerEvents(new LilyListener(this));
	}
	public void onDisable(){
		getBukkitConnect().unregisterEvents(new LilyListener(this));
	}
	public void request(String channel, String message) {
		Connect c = getBukkitConnect();
		   try {
	        	MessageRequest request = new MessageRequest(Collections.<String> emptyList(), channel, message);
	            	c.request(request); 
	           } catch (UnsupportedEncodingException | RequestException e) {
	        	e.printStackTrace();
	           }
		}
	public Connect getBukkitConnect(){
		return (Connect) this.getServer().getServicesManager().getRegistration(Connect.class).getProvider();
	}
		
}
