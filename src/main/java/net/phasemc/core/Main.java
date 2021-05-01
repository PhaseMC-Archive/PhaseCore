package net.phasemc.core;

import net.phasemc.core.commands.Script;
import net.phasemc.core.essentials.Flight;
import net.phasemc.core.essentials.Gamemodes;
import net.phasemc.core.essentials.TogglePlace;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.LogPrefix;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;
import org.bukkit.plugin.java.annotation.plugin.author.Authors;


//Main plugin declaration
@Plugin(name = "THE-CORE", version = "1.0")
@Description(desc = "The main core for the phase-mc server.")
@Authors({@Author(name = "shmezi"), @Author(name = "JordanPlayz158")})
@LogPrefix(prefix = "CORE")
@Website(url = "http://phasemc.net")
//Commands start here
@Commands({
        @Command(name = "gmsp"),
        @Command(name = "gms"),
        @Command(name = "gmc"),
        @Command(name = "gma"),
        @Command(name = "fly"),
        @Command(name = "script"),
        @Command(name = "toggleplace", permission = "core.toggleplace", permissionMessage = "You can't use this command!")
})
public class Main extends JavaPlugin {
    private static Main main;

    @Override
    public void onEnable(){
        main = this;

        this.getCommand("script").setExecutor(new Script());
        this.getCommand("gmc").setExecutor(new Gamemodes());
        this.getCommand("gms").setExecutor(new Gamemodes());
        this.getCommand("gmsp").setExecutor(new Gamemodes());
        this.getCommand("gma").setExecutor(new Gamemodes());
        this.getCommand("fly").setExecutor(new Flight());
        this.getCommand("toggleplace").setExecutor(new TogglePlace());

        this.getServer().getPluginManager().registerEvents(new EventListener(), this);

        Bukkit.getLogger().info("THE-CORE HAS BEEN ENABLED!");
    }

    public static Main getInstance() {
        return main;
    }



}
