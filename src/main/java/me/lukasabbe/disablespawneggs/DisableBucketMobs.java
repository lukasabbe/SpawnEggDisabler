package me.lukasabbe.disablespawneggs;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class DisableBucketMobs implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerBucketEmptyEvent event){
        if(!DisableSpawnEggs.instance.isBuketMobsOn()) return;
        if(event.getBucket().equals(Material.AXOLOTL_BUCKET) ||
                event.getBucket().equals(Material.COD_BUCKET) ||
                event.getBucket().equals(Material.PUFFERFISH_BUCKET) ||
                event.getBucket().equals(Material.SALMON_BUCKET) ||
                event.getBucket().equals(Material.TROPICAL_FISH_BUCKET) ||
                event.getBucket().equals(Material.TADPOLE_BUCKET)){
            event.setCancelled(true);
        }
    }
}
