package net.phasemc.core.scripts;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class test {
    public test(Player player, Command cmd, String label, String[] args, String arg) {
        player.sendMessage(ChatColor.RED + "you used" + arg + ChatColor.AQUA + "!");
    }
}
