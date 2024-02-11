package me.lukasabbe.disablespawneggs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0 || !Objects.equals(args[0], "reload")){
            return false;
        }
        DisableSpawnEggs.instance.reloadConfig();
        DisableSpawnEggs.instance.setIsSpawnersOn(DisableSpawnEggs.instance.getConfig().getBoolean("turn-of-spawners"));
        sender.sendMessage("Reloaded config");
        return true;
    }
}
