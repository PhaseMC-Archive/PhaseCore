package net.phasemc.core;

import net.phasemc.core.commands.CoreCommand;
import net.phasemc.core.essentials.Gamemodes;
import org.bukkit.plugin.java.JavaPlugin;
import net.phasemc.core.commands.Script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        System.out.println("THE-CORE HAS BEEN ENABLED!");
    }

    public static Main getInstance() {
        return main;
    }

    public List<CoreCommand> getCommands() {
        return commands;
    }
}
