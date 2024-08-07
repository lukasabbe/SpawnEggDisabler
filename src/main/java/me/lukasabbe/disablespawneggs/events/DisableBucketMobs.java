package me.lukasabbe.disablespawneggs.events;
import me.lukasabbe.disablespawneggs.DisableSpawnEggs;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class DisableBucketMobs implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerBucketEmptyEvent event){
        if(!DisableSpawnEggs.instance.isBuketMobsOn()) return;
        final Material bucket = event.getBucket();
        if(bucket.equals(Material.AXOLOTL_BUCKET) ||
                bucket.equals(Material.COD_BUCKET) ||
                bucket.equals(Material.PUFFERFISH_BUCKET) ||
                bucket.equals(Material.SALMON_BUCKET) ||
                bucket.equals(Material.TROPICAL_FISH_BUCKET) ||
                bucket.equals(Material.TADPOLE_BUCKET)){
            event.setCancelled(true);
        }
    }
}
