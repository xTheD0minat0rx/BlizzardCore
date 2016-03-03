package me.dominator.blizzardcore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.dominator.blizzardcore.Main;
import net.md_5.bungee.api.ChatColor;

public class AlertCommand implements CommandExecutor {
	private Main plugin;
	public AlertCommand(Main instance){
		plugin = instance;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("alert")){
			if(sender.hasPermission("admin.alert")){
				if(args.length == 0){
					sender.sendMessage(ChatColor.RED + "/alert <message>");
					return true;
				}
				StringBuilder str = new StringBuilder();
				for(int i = 0; i < args.length; i++){
					str.append(args[i]).append(" ");
				}
				String message = str.toString();
				plugin.request("alert", message);
			}else{
				return true;
			}
		}		
		return true;
	}
}
