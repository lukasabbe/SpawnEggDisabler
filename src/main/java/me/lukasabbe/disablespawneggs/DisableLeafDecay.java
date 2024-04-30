package me.lukasabbe.disablespawneggs;

import org.bukkit.Tag;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class DisableLeafDecay implements Listener {
    @EventHandler
    public void disableLeafDecay(LeavesDecayEvent block){
        if(Tag.LEAVES.isTagged(block.getBlock().getBlockData().getMaterial())){
            block.setCancelled(true);
            Leaves leaves = (Leaves) block.getBlock().getBlockData();
            leaves.setPersistent(true);
            block.getBlock().setBlockData(leaves);
        }
    }
}
