package me.lukasabbe.disablespawneggs.events;
import me.lukasabbe.disablespawneggs.DisableSpawnEggs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class SpawnEggListener implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        if(!DisableSpawnEggs.instance.isSpawnEggsOn()) return;
        final ItemStack item = event.getItem();
        if(item == null || item.getItemMeta() == null) return;
        if(item.getItemMeta() instanceof SpawnEggMeta && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onDispenserUse(BlockDispenseEvent event){
        if(!DisableSpawnEggs.instance.isSpawnEggsDispensersOn()) return;
        final ItemMeta itemMeta = event.getItem().getItemMeta();
        if(itemMeta == null) return;
        if(itemMeta instanceof SpawnEggMeta){
            event.setCancelled(true);
        }
    }

}
