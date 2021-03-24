package net.phasemc.core;

import net.phasemc.core.commands.CoreCommand;
import net.phasemc.core.commands.CorePlayerCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        /* cmd = command with plugin name
         * label = command
         * args = arguments after command
         *
         *      sender                                     command                                    label           args
         * Ex. CraftPlayer{name=JordanPlayz158} org.bukkit.command.PluginCommand(gmc, THE-CORE v0.0.1) gmc [a, a, a, a, a, a, a, a, a]
         */
        CoreCommand command = null;

        // Finds command in list of CoreCommands
        for(CoreCommand coreCommand : Main.getInstance().getCommands()) {
            if(coreCommand.getName().equals(label) || coreCommand.getAliases().contains(label)) {
                command = coreCommand;
                break;
            }
        }

        // Checks if command is null (i.e there are no commands in the list of CoreCommands)
        if(command == null) {
            sender.sendMessage("Command is null!");
            return false;
        }

        if(!hasPermission(sender, command.getPermission())) {
            return false;
        }

        final String errorMessage = label + " failed to execute properly. Check console for details!";

        // Checks if command extends CorePlayerCommand
        if(command.getClass().getSuperclass() == CorePlayerCommand.class) {
            CorePlayerCommand playerCommand = (CorePlayerCommand) command;
            // Checks if sender is a player and if they have proper permission to use the command
            if(isPlayer(sender)) {
                Player player = (Player) sender;

                // If playerCommand failed, notify the player, and return false (false signifies the command didn't execute properly)
                if(!playerCommand.onCommand(player, cmd, label, args)) {
                    player.sendMessage(errorMessage);
                    return false;
                }

                return true;
            } else {
                return false;
            }
        }

        if(!command.onCommand(sender, cmd, label, args)) {
            sender.sendMessage(errorMessage);
            return false;
        }

        return true;
    }

    public boolean isPlayer(CommandSender sender) {
        if(sender instanceof Player) {
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "Sender is not a player!");
            return false;
        }
    }

    public boolean hasPermission(CommandSender sender, String permission) {
        if(sender.hasPermission("core." + permission)) {
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "Sender does not have permission to use this command!");
            return false;
        }
    }
}
