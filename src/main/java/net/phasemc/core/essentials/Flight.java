package net.phasemc.core.essentials;

import net.phasemc.core.ArgCheck;
import net.phasemc.core.Main;
import net.phasemc.core.MessageManager;
import net.phasemc.core.MessageType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Flight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if((player = Main.playerCheck(sender)) != null) {
            if (ArgCheck.check(args, player)) {
                flight(player);
            } else {
                if (sender.hasPermission("core.flyother")) {
                    flight(Bukkit.getPlayer(args[0]));
                } else {
                    MessageManager.message(player, MessageType.PERMISSION);
                }
            }
        }
        return false;
    }

    public void flight(Player p){
        if (p.getAllowFlight()){
            p.setAllowFlight(false);
            if (p.isFlying()){
                p.setFlying(false);
            }
        }else{
            p.setAllowFlight(true);
            if (!p.isFlying()){
                p.setFlying(true);
            }
        }
    }
}
