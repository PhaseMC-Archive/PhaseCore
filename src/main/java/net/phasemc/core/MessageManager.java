package net.phasemc.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageManager {

    public static void message(MessageType type, CommandSender p) {

        switch (type) {
            case PERMISSION:
                p.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                break;
            case UKNOWN:
                p.sendMessage(ChatColor.RED + "Uknown command!");
                break;
            case ONLINE:
                p.sendMessage(ChatColor.RED + "Player is not online!");
                break;
            case SCRIPT_UNKNOWN:
                p.sendMessage(ChatColor.RED + "Uknown script!");
                break;
            case NOARGUMENT:
                p.sendMessage(ChatColor.RED + "No argument provided!");
                break;
            case FLYON:
                p.sendMessage(ChatColor.BLUE + "Flight has been enabled!");
                break;
            case FLYOFF:
                p.sendMessage(ChatColor.BLUE + "Flight has been disabled!");
        }
    }

    //Option not to include a player. Used for messages sent to console.
    public static void message(MessageType type) {
        switch (type) {
            case NONPLAYEREXEXECUTABLE:
                Bukkit.getLogger().info(ChatColor.RED + "Command only executable by player!");
                break;
            default:
                Bukkit.getLogger().info(ChatColor.RED + "Command only executable by player!");
        }
    }
}
