package net.phasemc.core.essentials;

import net.phasemc.core.Check;
import net.phasemc.core.MessageManager;
import net.phasemc.core.enums.MessageType;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class TogglePlace implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (Check.canPlace(p)) {

                Check.togglePlace.add(p);

            } else {

                Check.togglePlace.remove(p);

            }
            p.sendMessage(ChatColor.GREEN + "You can" + (Check.canPlace(p) ? "" : "'t") + " place blocks now.");
            return true;

        }
        MessageManager.message(MessageType.NONPLAYEREXEXECUTABLE);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
