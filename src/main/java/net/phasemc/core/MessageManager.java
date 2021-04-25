package net.phasemc.core;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageManager {

    public static void message(Player p, MessageType Type){

        switch (Type){
            case PERMISSION:
                p.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            case UKNOWN:
                p.sendMessage(ChatColor.RED + "Uknown command!");
            case ONLINE:
                p.sendMessage(ChatColor.RED + "Player is not online!");
        }
    }
}
