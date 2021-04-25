package net.phasemc.core;

import net.phasemc.core.commands.CoreCommand;
import net.phasemc.core.essentials.Gamemodes;
import org.bukkit.plugin.java.JavaPlugin;
import net.phasemc.core.commands.Script;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.LogPrefix;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//Main plugin declaration
@Plugin(name = "THE-CORE", version = "1.0")
@Description(desc = "The main core for the phase-mc server.")
@Author(name = "shmezi")
@Author(name = "Jordan")
@Author(name = "Other staff")
@LogPrefix(prefix = "CORE")
@Website(url = "http://phasemc.net")
//Commands start here
@Command(name = "gmsp")
@Command(name = "gms")
@Command(name = "gmc")
@Command(name = "gma")
public class Main extends JavaPlugin {

    private static Main main;
    private List<CoreCommand> commands;

    @Override
    public void onEnable(){
        main = this;

        CommandHandler commandHandler = new CommandHandler();

        commands = new ArrayList<>();
        commands.addAll(Collections.singletonList(new Gamemodes()));

        this.getCommand("script").setExecutor(commandHandler);
        this.getCommand("gmc").setExecutor(commandHandler);
        this.getCommand("gms").setExecutor(commandHandler);
        this.getCommand("gmsp").setExecutor(commandHandler);
        this.getCommand("gma").setExecutor(commandHandler);
        this.getCommand("fly").setExecutor(commandHandler);

        System.out.println("THE-CORE HAS BEEN ENABLED!");
    }

    public static Main getInstance() {
        return main;
    }

    public List<CoreCommand> getCommands() {
        return commands;
    }
}
