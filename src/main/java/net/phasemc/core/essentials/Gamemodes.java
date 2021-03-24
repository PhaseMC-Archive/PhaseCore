package net.phasemc.core.essentials;

import net.phasemc.core.commands.CorePlayerCommand;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Gamemodes extends CorePlayerCommand {
    public Gamemodes() {
        super("gm",
                Arrays.asList("gmc", "gma", "gmsp", "gms"),
                "gamemode"
        );
    }

    @Override
    public boolean onCommand(Player sender, Command command, String label, String[] args) {
        final String gamemode = ChatColor.BLUE + "" + ChatColor.BOLD + "Your gamemode has been set to ";

        switch (label.substring(2)) {
            // Sets GameMode to Creative
            case "c":
                sender.setGameMode(GameMode.CREATIVE);
                sender.sendMessage(gamemode + "creative!");
                break;
            // Sets GameMode to Adventure
            case "a":
                sender.setGameMode(GameMode.ADVENTURE);
                sender.sendMessage(gamemode + "adventure!");
                break;
            // Sets GameMode to Spectator
            case "sp":
                sender.setGameMode(GameMode.SPECTATOR);
                sender.sendMessage(gamemode + "spectator!");
                break;
            // Sets GameMode to Survival
            case "s":
                sender.setGameMode(GameMode.SURVIVAL);
                sender.sendMessage(gamemode + "survival!");
                break;

            default:
                System.out.println("SOMETHING IS VERY WRONG WITH YOUR CODE!!!");
                return false;
        }
        return true;
    }
}
