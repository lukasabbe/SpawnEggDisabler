package me.lukasabbe.disablespawneggs;

import org.bukkit.plugin.java.JavaPlugin;

public final class DisableSpawnEggs extends JavaPlugin {
    private boolean isSpawnersOn = false;
    public static DisableSpawnEggs instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new SpawnEggListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnersListener(), this);
        getCommand("DisableSpawnEggs").setExecutor(new ReloadCommand());
        isSpawnersOn = getConfig().getBoolean("turn-of-spawners");
        instance = this;
    }

    public boolean getIsSpawnersOn(){
        return isSpawnersOn;
    }
    public void setIsSpawnersOn(boolean isSpawnersOn){
        this.isSpawnersOn = isSpawnersOn;
    }

}
