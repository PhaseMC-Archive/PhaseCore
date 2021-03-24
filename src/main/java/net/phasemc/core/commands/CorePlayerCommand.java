package net.phasemc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import reactor.util.annotation.NonNull;

import java.util.List;

public abstract class CorePlayerCommand extends CoreCommand {
    public CorePlayerCommand(@NonNull String name, List<String> aliases, String permission) {
        super(name, aliases, permission);
    }

    public abstract boolean onCommand(Player sender, Command command, String label, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
