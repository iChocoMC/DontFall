package ichoco.dontfall.othersUtils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import ichoco.dontfall.DontFall_Main;
import ichoco.dontfall.runnables.UpdateItems;

public class LocationUtil {
    public static ArrayList<Location> heal = new ArrayList<>();
    public static ArrayList<Location> strength = new ArrayList<>();
    
    private FileConfiguration locationConfig;

    public LocationUtil(DontFall_Main plugin){
        locationConfig = plugin.getLocation();
        this.getAllLocations();
        plugin.getServer().getScheduler().runTaskTimer(plugin, new UpdateItems(heal, strength), 1200, 1200);
    }

    public void getAllLocations(){
        locationConfig.getStringList("heal").forEach(line -> heal.add(newLocation(line)));
        locationConfig.getStringList("strength").forEach(line -> strength.add(newLocation(line)));
    }

    //parts[0] = X | parts[1] = Y | parts[2] = Z | parts[3] = world
    public Location newLocation(String line){
        String[] parts = line.split(",");
        return new Location(
            Bukkit.getWorld(parts[3]),
            Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])
        );
    }
    
    public static void addLocation_Heal(Location loc){
        heal.add(loc);
    }
    public static void addLocation_Strength(Location loc){
        strength.add(loc);
    }
}