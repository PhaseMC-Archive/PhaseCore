package net.phasemc.core.essentials;

import net.phasemc.core.Check;
import net.phasemc.core.MessageManager;
import net.phasemc.core.enums.MessageType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Flight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if ((player = Check.player(sender)) != null) {
            if (Check.playerarg(args, player)) {
                flight(player);
            } else {
                if (Check.permission(player, "core.flyother")) {
                    flight(player);
                }
            }
        } else {
            MessageManager.message(MessageType.NONPLAYEREXEXECUTABLE);
        }
        return false;
    }

    public void flight(Player p) {
        if (p.getAllowFlight()) {
            p.setAllowFlight(false);
            MessageManager.message(MessageType.FLYOFF);
            if (p.isFlying()) {
                p.setFlying(false);
                MessageManager.message(MessageType.FLYOFF);
            }
        } else {
            p.setAllowFlight(true);
            MessageManager.message(MessageType.FLYON);
            if (!p.isFlying()) {
                p.setFlying(true);
                MessageManager.message(MessageType.FLYON);

            }
        }


    }

}
