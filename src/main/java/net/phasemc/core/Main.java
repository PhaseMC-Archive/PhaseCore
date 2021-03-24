package net.phasemc.core;

import net.phasemc.core.essentials.gma;
import org.bukkit.plugin.java.JavaPlugin;
import net.phasemc.core.commands.Script;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        System.out.println("THE-CORE HAS BEEN ENABLED!");
        this.getCommand("script").setExecutor(new Script());
        this.getCommand("gma").setExecutor(new gma());

    }
}
