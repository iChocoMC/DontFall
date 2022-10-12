package ichoco.dontfall;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ichoco.dontfall.commands.LocationCommand;
import ichoco.dontfall.othersUtils.LocationUtil;
import ichoco.dontfall.utils.ConfigUtil;

public class DontFall_Main extends JavaPlugin {
    private static DontFall_Main main;
    private static LocationUtil locationUtil;
    
    private FileConfiguration messages_config;
    private FileConfiguration location_config;

    private File location_file;

    @Override
    public void onEnable() {
        main = this;
        locationUtil = new LocationUtil(main);

        createFiles(this.getDataFolder());
        
        this.getCommand("location").setExecutor(new LocationCommand());        
        
        locationUtil.getAllLocations();
    }

    private void createFiles(File folder){
        if (!folder.exists()){
            folder.mkdirs();
        }
        ConfigUtil location = new ConfigUtil(folder, "location.yml");
        location_file = location.getFile();
        location_config = location.getConfig();

        messages_config = new ConfigUtil(folder, "messages.yml").getConfig();
    }


    public void saveConfig(File file, FileConfiguration config){
        try {
            config.save(file);
        } catch (Exception e) {
        }
    }


    public static DontFall_Main getInstance(){ return main; }

    public LocationUtil getLocationUtil(){ return locationUtil; }
    
    //Files .yml
    public FileConfiguration getMessages(){ return messages_config; }
    public FileConfiguration getLocation(){ return location_config; }

    public File getLocationFile(){ return location_file; }
}
