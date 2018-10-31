package me.lxct.bestviewdistance.functions;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

import static me.lxct.bestviewdistance.functions.get.getActualReductionIndice;
import static me.lxct.bestviewdistance.functions.get.getPlayerViewDistance;

public class set extends org.bukkit.plugin.java.JavaPlugin {

    private static void setPlayerViewDistance(Player player, int x){
        File file = new File("plugins/BestViewDistance/data/" + player.getUniqueId() + ".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("ViewDistance", x);
        try {
            config.save(file);
        } catch (IOException e) {
            Bukkit.getLogger().info("[BestViewDistance] Cannot edit yml files. Please make sure you have editing rights on the entire plugin folder.");
        }
    }


    public static void setServerReductionIndice(double x){
        File file = new File("plugins/BestViewDistance/data/server.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("ReductionIndice", x);
        try {
            config.save(file);
        } catch (IOException e) {
            Bukkit.getLogger().info("[BestViewDistance] Cannot edit yml files. Please make sure you have editing rights on the entire plugin folder.");
        }
    }

    private static void setPlayerLimits(Player player){
        int playerViewDistance = getPlayerViewDistance(player);
        if(playerViewDistance > variables.max){
            setPlayerViewDistance(player, variables.max);
        }
        else if(playerViewDistance < variables.min){
            setPlayerViewDistance(player, variables.min);
        }
    }

    public static void setServerLimits(){
        double ReductionIndice = getActualReductionIndice();
        if(ReductionIndice > variables.maxindice){
            setServerReductionIndice(variables.maxindice);
        }
        else if(ReductionIndice < 0){
            setServerReductionIndice(0);
        }
    }


    public static void setPlayersBestViewDistance(double ReductionIndice){
        for(Player player : Bukkit.getOnlinePlayers()) {
            int viewDistance = getPlayerViewDistance(player);
            if(player.spigot().getPing() < variables.aping){
                setPlayerViewDistance(player, viewDistance+1);
            }
            else if(player.spigot().getPing() >= variables.rping){
                setPlayerViewDistance(player, viewDistance-1);
            }
            player.setViewDistance((int) Math.round(viewDistance*(1-ReductionIndice)));
            setPlayerLimits(player);
        }
    }
}