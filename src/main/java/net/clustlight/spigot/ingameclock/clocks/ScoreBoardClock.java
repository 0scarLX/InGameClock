package net.clustlight.spigot.ingameclock.clocks;

import net.clustlight.spigot.ingameclock.InGameClockConfig;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.*;

public class ScoreBoardClock {

    public static Objective objective;
    public static Scoreboard scoreboard;

    public static void init() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard sb = manager.getNewScoreboard();

        Objective ob = sb.registerNewObjective("clock", "dummy", InGameClockConfig.get().getString("[settings].Score.Title"));
        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
        scoreboard = sb;
        objective = ob;
    }
}
