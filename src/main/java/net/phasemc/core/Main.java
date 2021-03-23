package net.phasemc.core;

import org.bukkit.Color;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import net.phasemc.core.commands.script;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        System.out.println("THE-CORE HAS BEEN ENABLED!");
        this.getCommand("script").setExecutor(new script());
    }
}
