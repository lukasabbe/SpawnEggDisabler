package me.lukasabbe.disablespawneggs;

import org.bukkit.plugin.java.JavaPlugin;

public final class DisableSpawnEggs extends JavaPlugin {
    private boolean isSpawnersOn = false;
    private boolean isBookCommandsOn = true;
    public static DisableSpawnEggs instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new SpawnEggListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnersListener(), this);
        getServer().getPluginManager().registerEvents(new DisableBookCommands(), this);
        getCommand("DisableSpawnEggs").setExecutor(new ReloadCommand());
        isSpawnersOn = getConfig().getBoolean("turn-of-spawners");
        isBookCommandsOn = getConfig().getBoolean("turn-of-commands-in-books");
        instance = this;
    }

    public boolean getIsSpawnersOn(){
        return isSpawnersOn;
    }
    public boolean getIsBookCommandsOn() {
        return isBookCommandsOn;
    }
    public void setIsSpawnersOn(boolean isSpawnersOn){
        this.isSpawnersOn = isSpawnersOn;
    }
    public void setIsBookCommandsOn(boolean isBookCommandsOn){
        this.isBookCommandsOn = isBookCommandsOn;
    }

}
