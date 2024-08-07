package me.lukasabbe.disablespawneggs.events;

import me.lukasabbe.disablespawneggs.DisableSpawnEggs;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SpawnersListener implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        if(!DisableSpawnEggs.instance.getIsSpawnersOn()) return;
        final ItemStack item = event.getItem();
        if(item == null) return;
        if((item.isSimilar(new ItemStack(Material.SPAWNER)) || item.isSimilar(new ItemStack(Material.TRIAL_SPAWNER))) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onSpawnerSpawn(SpawnerSpawnEvent event){
        if(!DisableSpawnEggs.instance.getIsSpawnersOn()) return;
        event.setCancelled(true);
    }
}
