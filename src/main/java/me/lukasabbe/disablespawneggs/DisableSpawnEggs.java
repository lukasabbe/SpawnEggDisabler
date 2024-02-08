package me.lukasabbe.disablespawneggs;

import org.bukkit.plugin.java.JavaPlugin;

public final class DisableSpawnEggs extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SpawnEggListener(), this);

    }

}
