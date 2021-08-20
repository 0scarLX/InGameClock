package net.clustlight.spigot.ingameclock;

import net.clustlight.spigot.ingameclock.clocks.TopBarClock;
import net.clustlight.spigot.ingameclock.clocks.ScoreBoardClock;
import net.clustlight.spigot.ingameclock.commands.InGameClockCommand;
import net.clustlight.spigot.ingameclock.commands.InGameClockTabCompletion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class InGameClock extends JavaPlugin {

    @Override
    public void onEnable() {

        // Commands Setup
        getCommand("igc").setExecutor(new InGameClockCommand());
        getCommand("igc").setTabCompleter(new InGameClockTabCompletion());

        //Configuration Setup
        InGameClockConfig.init();

        InGameClockConfig.get().addDefault("[settings].Bar.Formatting", "§6");
        InGameClockConfig.get().addDefault("[settings].Bar.TimeFormat", "yyyy/MM/dd  HH:mm:ss");

        InGameClockConfig.get().addDefault("[settings].Score.Title", "InGameClock");
        InGameClockConfig.get().addDefault("[settings].Score.Formatting", "§d");
        InGameClockConfig.get().addDefault("[settings].Score.TimeFormat", "HH:mm:ss");

        InGameClockConfig.get().options().copyDefaults(true);
        InGameClockConfig.save();

        // Clock Setup
        getServer().getPluginManager().registerEvents(new InGameClockListener(), this);
        TopBarClock.init();
        ScoreBoardClock.init();
        UpdateTask task = new UpdateTask();
        task.runTaskTimer(this, 0, 20);

        Bukkit.getOnlinePlayers().forEach(InGameClockManager::setClock);
    }

    @Override
    public void onDisable() {
        Bukkit.getOnlinePlayers().forEach(InGameClockManager::removeClock);
    }
}
