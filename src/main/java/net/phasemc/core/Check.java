package net.phasemc.core;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Check {


    public static boolean IsPlayer(CommandSender sender, String permission) {
        if (sender instanceof Player){
            Player player = (Player) sender;

            if (player.hasPermission("core." + permission)){

                return true;

            }else{
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");

            }
        }else{
            System.out.println(ChatColor.RED + "Command executable only be a player");

        }
        return false;
    }


}
