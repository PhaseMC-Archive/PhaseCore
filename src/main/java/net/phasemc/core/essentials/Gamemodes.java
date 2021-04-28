package net.phasemc.core.essentials;

import net.phasemc.core.Check;
import net.phasemc.core.MessageManager;
import net.phasemc.core.enums.MessageType;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemodes implements CommandExecutor {
    final String gamemode = ChatColor.BLUE + "" + ChatColor.BOLD + "Your gamemode has been set to ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player player;
        if ((player = Check.player(sender)) != null) {
            switch (label.substring(2)) {
                // Sets GameMode to Creative
                case "c":
                    gm(player, GameMode.CREATIVE);
                    break;
                // Sets GameMode to Adventure
                case "a":
                    gm(player, GameMode.ADVENTURE);
                    break;
                // Sets GameMode to Spectator
                case "sp":
                    gm(player, GameMode.SPECTATOR);
                    break;
                // Sets GameMode to Survival
                case "s":
                    gm(player, GameMode.SURVIVAL);
                    break;
                case "":
                    if (args.length != 0) {
                        switch (args[0].toLowerCase()) {
                            case "1":
                            case "c":
                                gm(player, GameMode.CREATIVE);
                                break;
                            case "a":
                            case "2":
                                gm(player, GameMode.ADVENTURE);
                                break;
                            case "sp":
                            case "3":
                                gm(player, GameMode.SPECTATOR);
                                break;
                            case "s":
                            case "0":
                                gm(player, GameMode.SURVIVAL);
                                break;
                        }
                    }


                default:
                    MessageManager.message(MessageType.FUCKEDUP);
                    return false;
            }
        } else {
            MessageManager.message(MessageType.NONPLAYEREXEXECUTABLE);
        }
        return true;
    }

    private void gm(Player player, GameMode g) {
        switch (g) {
            case CREATIVE:
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(gamemode + "creative!");
                break;
            case ADVENTURE:
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(gamemode + "adventure!");
                break;
            case SPECTATOR:
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(gamemode + "spectator!");
                break;
            case SURVIVAL:
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(gamemode + "survival!");
                break;
            default:
                MessageManager.message(MessageType.FUCKEDUP);
                break;
        }

    }
}
