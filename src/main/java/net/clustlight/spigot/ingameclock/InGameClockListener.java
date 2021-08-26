package net.clustlight.spigot.ingameclock;

import net.clustlight.spigot.ingameclock.clocks.InGameClockManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class InGameClockListener implements Listener {

    @EventHandler
    public static void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        InGameClockManager.setClock(player);
    }

}
