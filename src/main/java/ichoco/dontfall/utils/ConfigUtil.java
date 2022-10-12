package ichoco.dontfall.utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import ichoco.dontfall.DontFall_Main;

public class ConfigUtil {
    private File file;
    private FileConfiguration config;

    public ConfigUtil(File location, String name){
        file = new File(location, name);
        if (!file.exists()) {
            DontFall_Main.getInstance().saveResource(name, false);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile(){
        return this.file;
    }
    
    public FileConfiguration getConfig(){
        return this.config;
    }
}
