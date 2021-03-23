package net.phasemc.core.scripts;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.Color;

public class test {
    public test(Player player, Command cmd, String label, String[] args, String arg) {
        player.sendMessage(Color.RED + "you used" + arg + Color.AQUA + "!");
    }
}
