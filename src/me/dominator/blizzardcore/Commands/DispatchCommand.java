package me.dominator.blizzardcore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.dominator.blizzardcore.Main;
import net.md_5.bungee.api.ChatColor;

public class DispatchCommand implements CommandExecutor {
	private Main plugin;
	public DispatchCommand(Main instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(!sender.hasPermission("admin.dispatch")){
			sender.sendMessage(ChatColor.RED + "No permission.");
			return true;
		}
		if(args.length == 0){
			sender.sendMessage(ChatColor.RED + "/dispatch <command>");
			return true;
		}
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < args.length; i++){
			str.append(args[i]).append(" ");
		}
		String message = str.toString();
		plugin.request("dispatch", message);
		sender.sendMessage(ChatColor.RED + "The command has been sent to all servers!");
		
		
		return true;
	}
	
}
