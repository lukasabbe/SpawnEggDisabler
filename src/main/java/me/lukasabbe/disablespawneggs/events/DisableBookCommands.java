package me.lukasabbe.disablespawneggs.events;

import me.lukasabbe.disablespawneggs.DisableSpawnEggs;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class DisableBookCommands implements Listener {
    @EventHandler
    public void onBookEvent(PlayerInteractEvent event){
        if(!DisableSpawnEggs.instance.getIsBookCommandsOn()) return;
        final ItemStack item = event.getItem();
        if(item == null) return;
        if(item.hasItemMeta()){
            final ItemMeta itemMeta = item.getItemMeta();
            if(itemMeta instanceof BookMeta){
                PersistentDataContainer data = itemMeta.getPersistentDataContainer();
                NamespacedKey key = new NamespacedKey(DisableSpawnEggs.instance, "IsNulled");
                if(Boolean.TRUE.equals(data.get(key, PersistentDataType.BOOLEAN))){
                    return;
                }
                BookMeta book = (BookMeta) itemMeta;
                book.getPersistentDataContainer().set(key, PersistentDataType.BOOLEAN, true);
                List<String> pages = book.getPages();
                for(int i = 1; i < pages.size() + 1 ; i++){
                    book.setPage(i, pages.get(i-1));
                }
                item.setItemMeta(book);
                event.setCancelled(true);
                event.getPlayer().openBook(item);
            }
        }
    }
}
