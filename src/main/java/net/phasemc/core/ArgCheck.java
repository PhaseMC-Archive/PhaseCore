package net.phasemc.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ArgCheck {
    public static boolean check (String[] l, Player p){
        if (l.length == 0){
            return false;
        }else if (Bukkit.getPlayer(l[0]).isOnline()){
            return true;

        }else{
            MessageManager.message(p, MessageType.ONLINE);
            return false;
        }
    }
}
