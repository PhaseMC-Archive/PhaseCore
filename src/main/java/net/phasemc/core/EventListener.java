package net.phasemc.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        e.setCancelled(!Check.canPlace(e.getPlayer()));

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {

        e.setCancelled(!Check.canPlace(e.getPlayer()));

    }

}
