package ichoco.dontfall.othersUtils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import ichoco.dontfall.DontFall_Main;
import ichoco.dontfall.runnables.UpdateItems;

public class LocationUtil {
    public static ArrayList<Location> strong = new ArrayList<>();
    public static ArrayList<Location> heal = new ArrayList<>();

    private FileConfiguration locationConfig;

    public LocationUtil(DontFall_Main plugin){
        locationConfig = plugin.getLocation();
        plugin.getServer().getScheduler().runTaskTimer(plugin, new UpdateItems(strong, heal), 1200, 1200);
    }

    public void getAllLocations(){
        int x, z, y;
        String[] parts;
        for(String line : locationConfig.getStringList("strong")){
            parts = line.split(",");
            x = Integer.parseInt(parts[0]);
            y = Integer.parseInt(parts[1]);
            z = Integer.parseInt(parts[2]);
            strong.add(new Location(Bukkit.getWorld(parts[3]), x, y, z));  
        }

        for(String line : locationConfig.getStringList("heal")){
            parts = line.split(",");
            x = Integer.parseInt(parts[0]);
            y = Integer.parseInt(parts[1]);
            z = Integer.parseInt(parts[2]);
            heal.add(new Location(Bukkit.getWorld(parts[3]), x, y, z));
        }
    }
    
    public static void addLocation_Heal(Location loc){ heal.add(loc); }
    public static void addLocation_Strong(Location loc){ strong.add(loc); }
}