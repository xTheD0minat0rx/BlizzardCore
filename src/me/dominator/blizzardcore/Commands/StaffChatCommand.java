package me.dominator.blizzardcore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.dominator.blizzardcore.Main;
import net.md_5.bungee.api.ChatColor;

public class StaffChatCommand implements CommandExecutor {
	private Main plugin;
	public StaffChatCommand(Main instance){
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(!sender.hasPermission("staff.chat")){
			sender.sendMessage(ChatColor.RED + "No permission.");
			return true;
		}
		if(args.length == 0){
			sender.sendMessage(ChatColor.RED + "/a <message>");
			return true;
		}
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < args.length; i++){
			str.append(args[i]).append(" ");
		}
		String message = ChatColor.translateAlternateColorCodes('&', "&8[&3STAFF&8] &b" + plugin.getBukkitConnect().getSettings().getUsername() + " &8| &b" + sender.getName() + " &8| &b" + str.toString());                                                                         
		plugin.request("staffchat", message);
		
		return true;
	}
}
