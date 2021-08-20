package net.clustlight.spigot.ingameclock.commands;

import net.clustlight.spigot.ingameclock.InGameClockConfig;
import net.clustlight.spigot.ingameclock.InGameClockManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InGameClockCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("[InGameClock] Commands are only available when it are issued by the In-Game Players");
            return true;
        }

        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("igc")) {
            if(args.length > 0){
                if(args[0].equalsIgnoreCase("bar")) {

                    InGameClockConfig.get().set(player.getName(), "bar");
                    InGameClockConfig.save();

                    InGameClockManager.setClock(player);
                    player.sendMessage(ChatColor.GOLD+"[InGameClock] " + ChatColor.AQUA + "In-Game Clock is now Bar mode");

                }else if(args[0].equalsIgnoreCase("score")) {

                    InGameClockConfig.get().set(player.getName(), "score");
                    InGameClockConfig.save();

                    InGameClockManager.setClock(player);
                    player.sendMessage(ChatColor.GOLD+"[InGameClock] " + ChatColor.YELLOW + "In-Game Clock is now Score mode");

                }else if(args[0].equalsIgnoreCase("off")){

                    InGameClockConfig.get().set(player.getName(), "off");
                    InGameClockConfig.save();

                    InGameClockManager.setClock(player);
                    player.sendMessage(ChatColor.GOLD+"[InGameClock] " + ChatColor.RED + "In-Game Clock is now Disabled");

                }else{
                    player.performCommand("help igc");
                }
            }else{
                player.performCommand("help igc");
            }
        }
        return true;
    }
}
