package ichoco.dontfall;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ichoco.dontfall.commands.LocationCommand;
import ichoco.dontfall.listeners.*;
import ichoco.dontfall.othersUtils.LocationUtil;
import ichoco.dontfall.utils.ConfigUtil;

public class DontFall_Main extends JavaPlugin {
    private static DontFall_Main main;

    private FileConfiguration messages_config;
    private FileConfiguration location_config;

    @Override
    public void onEnable() {
        main = this;
        createFiles(this.getDataFolder());
        registerListeners();

        new LocationUtil(main);
        
        this.getCommand("location").setExecutor(new LocationCommand());                
    }

    private void createFiles(File folder){
        if (!folder.exists()){
            folder.mkdirs();
        }
        location_config = new ConfigUtil(folder, "location.yml").getConfig();
        messages_config = new ConfigUtil(folder, "messages.yml").getConfig();
    }

    public void saveConfig(File file, FileConfiguration config){
        try {
            config.save(file);
        } catch (Exception e) {
        }
    }

    private void registerListeners(){
        PluginManager plugin_manager = this.getServer().getPluginManager();
        plugin_manager.registerEvents(new Feed(), this);
        plugin_manager.registerEvents(new ItemPickup(), this);
        plugin_manager.registerEvents(new Movement(), this);
        plugin_manager.registerEvents(new Others(), this);
    }

    public static DontFall_Main getInstance(){
        return main;
    }
    
    //Files .yml
    public FileConfiguration getMessages(){
        return messages_config; 
    }

    public FileConfiguration getLocation(){
        return location_config;
    }
}
