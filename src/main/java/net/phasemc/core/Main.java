package net.phasemc.core;

import net.phasemc.core.essentials.Gamemodes;
import org.bukkit.plugin.java.JavaPlugin;
import net.phasemc.core.commands.Script;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        System.out.println("THE-CORE HAS BEEN ENABLED!");
        this.getCommand("script").setExecutor(new Script());
        this.getCommand("gmc").setExecutor(new Gamemodes());
        this.getCommand("gms").setExecutor(new Gamemodes());
        this.getCommand("gmsp").setExecutor(new Gamemodes());
        this.getCommand("gma").setExecutor(new Gamemodes());


    }
}
