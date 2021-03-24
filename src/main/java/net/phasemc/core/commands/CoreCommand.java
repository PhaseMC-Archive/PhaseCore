package net.phasemc.core.commands;

import com.avaje.ebean.validation.NotNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import reactor.util.annotation.NonNull;

import java.util.List;

public abstract class CoreCommand {
    private String name;
    private List<String> aliases;
    private String permission;

    public CoreCommand(@NonNull String name, List<String> aliases, String permission) {
        this.name = name;

        if(aliases != null) {
            this.aliases = aliases;
        }

        if(permission != null) {
            this.permission = permission;
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getPermission() {
        return permission;
    }

    public abstract boolean onCommand(CommandSender sender, Command command, String label, String[] args);
}
