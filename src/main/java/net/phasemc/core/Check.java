package net.phasemc.core;

import net.phasemc.core.enums.MessageType;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Check {

    public static List<Player> togglePlace = new ArrayList<Player>();

    public static boolean playerarg (String[] l, Player p){
        if (l.length == 0){
            return false;
        }else if (Bukkit.getPlayer(l[0]).isOnline()){
            return true;

        }else{
            MessageManager.message(MessageType.ONLINE, p);
            return false;
        }
    }
    public static boolean permission(Player p, String permission){
        if (p.hasPermission(permission)){
            return true;
        }else{

            MessageManager.message(MessageType.PERMISSION, p);
            return false;
        }
    }
    public static Player player(CommandSender sender) {
        if(sender instanceof Player) {
            return (Player) sender;
        } else {
            return null;
        }
    }
    public static boolean canPlace(Player p) {

        return !togglePlace.contains(p);

    }
}
