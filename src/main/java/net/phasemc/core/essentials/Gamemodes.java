package net.phasemc.core.essentials;

import net.phasemc.core.Check;
import net.phasemc.core.Main;
import net.phasemc.core.MessageManager;
import net.phasemc.core.MessageType;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemodes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final String gamemode = ChatColor.BLUE + "" + ChatColor.BOLD + "Your gamemode has been set to ";

        Player player;
        if((player = Check.player(sender)) != null) {
            switch (label.substring(2)) {
                // Sets GameMode to Creative
                case "c":
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(gamemode + "creative!");
                    break;
                // Sets GameMode to Adventure
                case "a":
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(gamemode + "adventure!");
                    break;
                // Sets GameMode to Spectator
                case "sp":
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(gamemode + "spectator!");
                    break;
                // Sets GameMode to Survival
                case "s":
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(gamemode + "survival!");
                    break;

                default:
                    System.out.println("SOMETHING IS VERY WRONG WITH YOUR CODE!!!");
                    return false;
            }
        }else{
            MessageManager.message(MessageType.NONPLAYEREXEXECUTABLE);
        }
        return true;
    }
}
