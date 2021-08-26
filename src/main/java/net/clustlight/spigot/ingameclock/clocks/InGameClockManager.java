package net.clustlight.spigot.ingameclock.clocks;

import net.clustlight.spigot.ingameclock.InGameClockConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class InGameClockManager {

    public static void setClock(Player player){

        // Initialization
        removeClock(player);

        String string = InGameClockConfig.get().getString(player.getName());

        if (string == null) {
            TopBarClock.bar.addPlayer(player);
            player.setScoreboard(ScoreBoardClock.scoreboard);
            player.sendMessage(ChatColor.GOLD+"[In-GameClock] " + ChatColor.AQUA + "To change the clock type, use " + ChatColor.DARK_RED + "/igc");
            return;
        }

        switch (string) {

            case "bar":
                TopBarClock.bar.addPlayer(player);
                player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
                break;

            case "score":
                player.setScoreboard(ScoreBoardClock.scoreboard);
                TopBarClock.bar.removePlayer(player);
                break;

            case "off":
            default:
                break;

        }
    }

    public static void removeClock(Player player) {
        TopBarClock.bar.removePlayer(player);
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }

}
