package net.clustlight.spigot.ingameclock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class InGameClockTabCompletion implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> tab = new ArrayList<>();

            tab.add("bar");
            tab.add("score");
            tab.add("off");

            return tab;
        }
        return null;
    }
}
