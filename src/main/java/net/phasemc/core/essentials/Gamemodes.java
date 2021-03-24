package net.phasemc.core.essentials;

import net.phasemc.core.PermissionOnlyPlayer;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemodes implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (PermissionOnlyPlayer.PermissionOnlyPlayer(sender, "gamemodes")) {
            Player player = (Player) sender;
            switch (cmd.getName()) {
                case "gmc":
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Your gamemode has been set to creative!");
                    break;
                case "gma":
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Your gamemode has been set to adventure!");
                    break;
                case "gmsp":
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Your gamemode has been set to spectator!");
                    break;
                case "gms":
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Your gamemode has been set to survival!");
                    break;

                default:
                    System.out.println("SOMETHING IS VERY WRONG WITH YOUR CODE!!!");
            }
        }


        return false;
    }
}
