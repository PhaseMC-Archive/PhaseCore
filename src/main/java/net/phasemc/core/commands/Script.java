package net.phasemc.core.commands;

import net.phasemc.core.scripts.Test;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Script implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Checks if the sender is a player.
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Checks if the player has the proper permissions to execute the command
            if (player.hasPermission("core.script")) {
                // Checks if the player specified any arguments (prevents IndexOutOfBounds exception)
                if (args.length != 0) {
                    String arg = args[0];
                    switch (arg) {
                        case "test":
                            new Test(player, cmd, label, args, arg);
                            break;
                        default:
                            player.sendMessage(ChatColor.RED + "Uknown Script!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "No argument provided!");
                }
            } else {
                player.sendMessage(ChatColor.RED +"Sorry, you don't have permission to use that command!");
            }
        } else {
            System.out.println(ChatColor.RED + "Scripts are only executable by player!");

        }
        return false;
    }
}
