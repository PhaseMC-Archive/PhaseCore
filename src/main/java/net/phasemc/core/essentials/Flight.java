package net.phasemc.core.essentials;

import net.phasemc.core.Check;
import net.phasemc.core.Main;
import net.phasemc.core.MessageManager;
import net.phasemc.core.MessageType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Flight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if((player = Check.player(sender)) != null) {
            if (Check.player(args, player)) {
                flight(player);
            } else {
                if (sender.hasPermission("core.flyother")) {

                } else {
                    MessageManager.message(MessageType.PERMISSION, player);
                }
            }
        }else{
            MessageManager.message(MessageType.NONPLAYEREXEXECUTABLE);
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
