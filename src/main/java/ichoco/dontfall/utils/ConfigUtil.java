package ichoco.dontfall.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import ichoco.dontfall.DontFall_Main;

public class ConfigUtil {
    private File file;
    private FileConfiguration config;
    
    public ConfigUtil(File location, String name){
        file = new File(location, name);
        createFile(file);
        config = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }
    
    private void createFile(File file){
        if (!file.exists()) {
            DontFall_Main.getInstance().saveResource("messages.yml", false);
        }
    }

    public void saveConfig() {
        try {
            config.save(file);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile(){
        return this.file;
    }
    
    public FileConfiguration getConfig(){
        return this.config;
    }
}
