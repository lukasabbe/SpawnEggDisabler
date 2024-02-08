package me.lukasabbe.disablespawneggs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class SpawnEggListener implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        if(event.getItem() == null || event.getItem().getItemMeta() == null) return;
        if(event.getItem().getItemMeta() instanceof SpawnEggMeta && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            event.setCancelled(true);
        }
    }

}
