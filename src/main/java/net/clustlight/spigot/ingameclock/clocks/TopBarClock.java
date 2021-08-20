package net.clustlight.spigot.ingameclock.clocks;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;

public class TopBarClock {

    public static BossBar bar;

    public static void init() {
        bar = Bukkit.createBossBar(
                "TopBarClock",
                BarColor.PINK,
                BarStyle.SEGMENTED_6
        );
    }
}
