package net.phasemc.core.essentials;

import net.phasemc.core.PermissionOnlyPlayer;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmsp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(PermissionOnlyPlayer.PermissionOnlyPlayer(sender, "gmsp")){
            Player player = (Player) sender;
            player.setGameMode(GameMode.SPECTATOR);
        }
        return false;
    }
}