package me.red;

import me.red.listener.fallDamageListener;
import me.red.loopClass.loopRegionCheck;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    public static Main Instance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new fallDamageListener(),this);
        new loopRegionCheck().loopRegion();
        loadMessage();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadMessage(){
        getLogger().info("    _   __      _______           __  ______      ____");
        getLogger().info("   / | / /___  / ____(_)_________/ /_/ ____/___ _/ / /");
        getLogger().info("  /  |/ / __ \\/ /_  / / ___/ ___/ __/ /_  / __ `/ / /");
        getLogger().info(" / /|  / /_/ / __/ / / /  (__  ) /_/ __/ / /_/ / / /");
        getLogger().info("/_/ |_/\\____/_/   /_/_/  /____/\\__/_/    \\__,_/_/_/");
        getLogger().info("Plugin made by RedBoy for ThunderLand");
    }
}
