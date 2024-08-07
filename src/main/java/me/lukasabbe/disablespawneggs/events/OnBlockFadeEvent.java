package me.lukasabbe.disablespawneggs.events;

import me.lukasabbe.disablespawneggs.DisableSpawnEggs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class OnBlockFadeEvent implements Listener {
    @EventHandler
    public void onBlockFadeEvent(BlockFadeEvent block){
        if(!DisableSpawnEggs.instance.isBlockFadingOn()) return;
        block.setCancelled(true);
    }
}
