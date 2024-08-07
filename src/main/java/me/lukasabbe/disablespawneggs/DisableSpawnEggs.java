package me.lukasabbe.disablespawneggs;

import me.lukasabbe.disablespawneggs.commands.ReloadCommand;
import me.lukasabbe.disablespawneggs.events.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DisableSpawnEggs extends JavaPlugin {
    private boolean isSpawnersOn = true;
    private boolean isBookCommandsOn = true;
    private boolean isBuketMobsOn = true;
    private boolean isSpawnEggsOn = true;
    private boolean isSpawnEggsDispensersOn = true;
    private boolean isBlockFadingOn = true;
    public static DisableSpawnEggs instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        final PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new SpawnEggListener(), this);
        pluginManager.registerEvents(new SpawnersListener(), this);
        pluginManager.registerEvents(new DisableBookCommands(), this);
        pluginManager.registerEvents(new DisableBucketMobs(), this);
        pluginManager.registerEvents(new OnBlockFadeEvent(),this);
        pluginManager.registerEvents(new DisableLeafDecay(), this);
        getCommand("DisableSpawnEggs").setExecutor(new ReloadCommand());
        final FileConfiguration config = getConfig();
        isSpawnersOn = config.getBoolean("turn-of-spawners");
        isBookCommandsOn = config.getBoolean("turn-of-commands-in-books");
        isBuketMobsOn = config.getBoolean("turn-of-buket-mobs");
        isSpawnEggsOn = config.getBoolean("turn-of-spawn-eggs");
        isSpawnEggsDispensersOn = config.getBoolean("turn-of-spawn-eggs-in-dispensers");
        isBlockFadingOn = config.getBoolean("turn-of-block-fade");

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
    public boolean isBuketMobsOn() {
        return isBuketMobsOn;
    }
    public void setBuketMobsOn(boolean buketMobsOn) {
        isBuketMobsOn = buketMobsOn;
    }
    public boolean isSpawnEggsOn() {
        return isSpawnEggsOn;
    }
    public void setSpawnEggsOn(boolean spawnEggsOn) {
        isSpawnEggsOn = spawnEggsOn;
    }
    public boolean isSpawnEggsDispensersOn() {
        return isSpawnEggsDispensersOn;
    }
    public void setSpawnEggsDispensersOn(boolean spawnEggsDispensersOn) {
        isSpawnEggsDispensersOn = spawnEggsDispensersOn;
    }
    public boolean isBlockFadingOn() {
        return isBlockFadingOn;
    }
    public void setBlockFadingOn(boolean blockFadingOn) {
        isBlockFadingOn = blockFadingOn;
    }
}
