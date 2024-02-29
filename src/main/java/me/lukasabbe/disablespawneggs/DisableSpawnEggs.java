package me.lukasabbe.disablespawneggs;

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
        getServer().getPluginManager().registerEvents(new SpawnEggListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnersListener(), this);
        getServer().getPluginManager().registerEvents(new DisableBookCommands(), this);
        getServer().getPluginManager().registerEvents(new DisableBucketMobs(), this);
        getServer().getPluginManager().registerEvents(new OnBlockFadeEvent(),this);
        getCommand("DisableSpawnEggs").setExecutor(new ReloadCommand());
        isSpawnersOn = getConfig().getBoolean("turn-of-spawners");
        isBookCommandsOn = getConfig().getBoolean("turn-of-commands-in-books");
        isBuketMobsOn = getConfig().getBoolean("turn-of-buket-mobs");
        isSpawnEggsOn = getConfig().getBoolean("turn-of-spawn-eggs");
        isSpawnEggsDispensersOn = getConfig().getBoolean("turn-of-spawn-eggs-in-dispensers");
        isBlockFadingOn = getConfig().getBoolean("turn-of-block-fade");
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
