package net.clustlight.spigot.ingameclock;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class InGameClockConfig {

    private static File file;
    private static FileConfiguration config;

    public static void init() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("InGameClock").getDataFolder(), "config.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException exception){
                System.out.println("Could not create file");
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return config;
    }

    public static void save(){
        try{
            config.save(file);
        }catch (IOException exception){
            System.out.println("Could not save file");
        }
    }

}
