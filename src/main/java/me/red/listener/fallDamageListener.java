package me.red.listener;


import me.red.Main;
import me.red.utils.WorldGuardUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class fallDamageListener implements Listener {
    Main plugin = Main.Instance();
    public static List<Player> firstFallDamage = new ArrayList<>();

    @EventHandler
    public void onFallDamage(EntityDamageEvent e){
        if (e.getEntity() instanceof Player){
            Player p = (Player)e.getEntity();
            if (WorldGuardUtils.isLocInRegion(p.getLocation(),plugin.getConfig().getString("spawn-name"))) return;
                if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && !(firstFallDamage.contains(p))) {
                    firstFallDamage.add(p);
                    e.setCancelled(true);
                    return;
            }
        }
    }
}
