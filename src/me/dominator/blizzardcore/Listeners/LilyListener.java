package me.dominator.blizzardcore.Listeners;

import java.io.UnsupportedEncodingException;

import org.bukkit.entity.Player;

import lilypad.client.connect.api.event.EventListener;
import lilypad.client.connect.api.event.MessageEvent;
import me.dominator.blizzardcore.Main;
import net.md_5.bungee.api.ChatColor;

public class LilyListener {
	private Main plugin;
	public LilyListener(Main instance){
		plugin = instance;
	}

	String message = null;
	@EventListener
	public void onAlert(MessageEvent event){
		if(event.getChannel().equalsIgnoreCase("alert")){
				String message;
				try {
					message = event.getMessageAsString();
					plugin.getServer().broadcastMessage("§8§m--------------------------------");
					plugin.getServer().broadcastMessage("");
					plugin.getServer().broadcastMessage("§4Network Alert:");
					plugin.getServer().broadcastMessage(ChatColor.RED + message);
					plugin.getServer().broadcastMessage("");
					plugin.getServer().broadcastMessage("§8§m--------------------------------");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				

		}
		if(event.getChannel().equalsIgnoreCase("dispatch")){
			String message;
			try{
				message = event.getMessageAsString();
				plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), message);
			}catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
			
			
			
		}
		if(event.getChannel().equalsIgnoreCase("staffchat")){
			String message;
			try{
				message = event.getMessageAsString();
				for(Player p : plugin.getServer().getOnlinePlayers()){
					if(p.hasPermission("staff.chat")){
						p.sendMessage(message);
					}
				}
			}catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}

			
			
		}
	}
}
