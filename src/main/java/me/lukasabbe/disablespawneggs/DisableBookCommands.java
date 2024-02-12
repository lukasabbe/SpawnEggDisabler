package me.lukasabbe.disablespawneggs;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class DisableBookCommands implements Listener {
    @EventHandler
    public void onBookEvent(PlayerInteractEvent event){
        if(!DisableSpawnEggs.instance.getIsBookCommandsOn()) return;
        if(event.getItem() == null) return;
        if(event.getItem().hasItemMeta()){
            if(event.getItem().getItemMeta() instanceof BookMeta){
                PersistentDataContainer data = event.getItem().getItemMeta().getPersistentDataContainer();
                NamespacedKey key = new NamespacedKey(DisableSpawnEggs.instance, "IsNulled");
                if(Boolean.TRUE.equals(data.get(key, PersistentDataType.BOOLEAN))){
                    return;
                }
                //event.getPlayer().sendMessage("Removing bad data from book");
                BookMeta book = (BookMeta) event.getItem().getItemMeta();
                book.getPersistentDataContainer().set(key, PersistentDataType.BOOLEAN, true);
                List<String> pages = book.getPages();
                for(int i = 1; i < pages.size() + 1 ; i++){
                    book.setPage(i, pages.get(i-1));
                }
                event.getItem().setItemMeta(book);
                event.setCancelled(true);
                event.getPlayer().openBook(event.getItem());
            }
        }
    }
}
