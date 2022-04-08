package me.red.loopClass;

import me.red.Main;
import me.red.utils.WorldGuardUtils;
import org.bukkit.Bukkit;

public class loopRegionCheck {
    Main plugin = Main.Instance();

    public void loopRegion(){
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            WorldGuardUtils.searchPlayer(Bukkit.getWorld(plugin.getConfig().getString("world-name")),plugin.getConfig().getString("spawn-name"));
        }, 20L, plugin.getConfig().getInt("check-time"));
    }
}
