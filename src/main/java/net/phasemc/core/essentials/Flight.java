package net.phasemc.core.essentials;

import com.sun.org.apache.xpath.internal.Arg;
import net.phasemc.core.ArgCheck;
import net.phasemc.core.MessageManager;
import net.phasemc.core.MessageType;
import net.phasemc.core.commands.CorePlayerCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import net.phasemc.core.MessageManager;

public class Flight extends CorePlayerCommand {

    public Flight() {
        super("fly",
                null,
                "fly"
        );
    }

    public void flight(Player p){
        if (p.getAllowFlight()){
            p.setAllowFlight(false);
            if (p.isFlying()){
                p.setFlying(false);
            }
        }else{
            p.setAllowFlight(true);
            if (!p.isFlying()){
                p.setFlying(true);
            }
        }
    }
    @Override
    public boolean onCommand(Player sender, Command command, String label, String[] args) {
        if (new ArgCheck().check(args, sender)){
            flight(sender);
        }else {
            if (sender.hasPermission("core.flyother")){
                flight(Bukkit.getPlayer(args[0]));
            }else{
                MessageManager.message(sender, MessageType.PERMISSION);
            }
        }
        return false;
    }
}
