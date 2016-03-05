package me.dominator.blizzardcore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.dominator.blizzardcore.Main;
import net.md_5.bungee.api.ChatColor;

public class InfoCommand implements CommandExecutor {
	
	private Main plugin;
	public InfoCommand(Main instance){
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(!sender.hasPermission("admin.info")){
			sender.sendMessage(ChatColor.RED + "No permission.");
			return true;
		}
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&m--------------------------------"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cBlizzardCore - Version: " + plugin.getDescription().getVersion()));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&m--------------------------------"));
		
		
		return true;
	}
	
}
