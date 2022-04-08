package me.red.utils;

import com.sk89q.worldguard.bukkit.RegionContainer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.red.Main;
import me.red.listener.fallDamageListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class WorldGuardUtils {
    static Main instance = Main.Instance();

    public static boolean isLocInRegion(Location loc, String regionName) {
        RegionContainer container = getWorldGuard().getRegionContainer();
        RegionManager regions = container.get(loc.getWorld());
        ApplicableRegionSet set = regions.getApplicableRegions(loc);

        if (set == null)
            return false;

        for (ProtectedRegion r : set)
            if (r.getId().equalsIgnoreCase(regionName))
                return true;
        return false;
    }

    private static WorldGuardPlugin getWorldGuard() {
        Plugin plugin = instance.getServer().getPluginManager().getPlugin("WorldGuard");

        if (plugin == null || !(plugin instanceof WorldGuardPlugin))
            return null;
        return (WorldGuardPlugin) plugin;
    }

    private static ProtectedRegion getRegion(World world, String regionName){
        RegionContainer container = getWorldGuard().getRegionContainer();
        RegionManager regions = container.get(world);
        if (regions != null)
            return regions.getRegion(regionName);
        return null;
    }

    public static void searchPlayer(World world, String regionName){
        ProtectedRegion region = getRegion(world,regionName);
        if (Bukkit.getOnlinePlayers().length == 0) return;
        for (Player p : Bukkit.getOnlinePlayers())
            if (region.contains((int)p.getLocation().getX(),(int)p.getLocation().getY(),(int)p.getLocation().getZ()))
                fallDamageListener.firstFallDamage.remove(p);
    }

}
