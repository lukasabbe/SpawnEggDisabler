package me.lukasabbe.disablespawneggs;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class SpawnersListener implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        if(!DisableSpawnEggs.instance.getIsSpawnersOn()) return;
        if(event.getItem() == null) return;
        if(event.getItem().isSimilar(new ItemStack(Material.SPAWNER)) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            event.setCancelled(true);
        }
    }
}
