package net.phasemc.core.commands;

import net.phasemc.core.MessageManager;
import net.phasemc.core.enums.MessageType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Script implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Checks if the sender is a player.


        // Checks if the player has the proper permissions to execute the command
        if (sender.hasPermission("core.script")) {
            // Checks if the player specified any arguments (prevents IndexOutOfBounds exception)
            if (args.length != 0) {
                String arg = args[0];
                try {

                    Class<?> classer = Class.forName("net.phasemc.core.scripts." + arg);
                    Constructor<?> constructor = classer.getConstructor(CommandSender.class, Command.class, String.class, String[].class, String.class);
                    Object instance = constructor.newInstance(sender, cmd, label, args, arg);
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    MessageManager.message(MessageType.SCRIPT_UNKNOWN, sender);
                }
            } else {
                MessageManager.message(MessageType.NOARGUMENT, sender);
            }
        } else {
            MessageManager.message(MessageType.PERMISSION, sender);
        }

        return false;
    }
}
