package net.phasemc.core.essentials;

import net.phasemc.core.Main;
import net.phasemc.core.MessageManager;
import net.phasemc.core.enums.MessageType;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Spawn implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            switch (cmd.getLabel().toLowerCase()) {

                case "spawn":
                    Player p = (Player) sender;

                    List<Integer> spawn = Main.getInstance().getConfig().getIntegerList("spawn");

                    if (spawn.isEmpty()) {
                        p.sendMessage(ChatColor.RED + "You need to set the spawn first!");
                        return true;
                    }

                    double x = spawn.get(0).doubleValue() + 0.5D;
                    double y = spawn.get(1).doubleValue();
                    double z = spawn.get(2).doubleValue() + 0.5D;

                    p.teleport(new Location(Main.getInstance().getServer().getWorld("world"), x, y, z));
                    p.sendMessage(ChatColor.GREEN + "Teleported you to the spawn!");
                    return true;

                case "setspawn":

                    Player player = (Player) sender;

                    int spawnX = player.getLocation().getBlockX();
                    int spawnY = player.getLocation().getBlockY();
                    int spawnZ = player.getLocation().getBlockZ();

                    List<Integer> spawnLoc = Arrays.asList(spawnX, spawnY, spawnZ);

                    Main.getInstance().getConfig().set("spawn", spawnLoc);
                    Main.getInstance().saveConfig();
                    player.sendMessage(ChatColor.GREEN + "Spawn set to: " + String.valueOf(spawnX) + ", " + String.valueOf(spawnY) + ", " + String.valueOf(spawnZ) + ".");

            }



        }
        MessageManager.message(MessageType.NONPLAYEREXEXECUTABLE);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
