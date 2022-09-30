package ichoco.dontfall;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ichoco.dontfall.commands.LocationCommand;
import ichoco.dontfall.othersUtils.Messages;
import ichoco.dontfall.utils.ConfigUtil;

public class DontFall_Main extends JavaPlugin {
    private FileConfiguration messages;

    @Override
    public void onEnable() {
        
        this.getCommand("location").setExecutor(new LocationCommand());
        
        buildConfigs(getDataFolder());
        Messages.loadMessages();
    }

    private void buildConfigs(File folder){
        if (!folder.exists()){
            folder.mkdirs();
        }
        messages = new ConfigUtil(folder, "messages.yml").getConfig();
    }

    public FileConfiguration getMessages(){
        return this.messages;
    }

    public static DontFall_Main getInstance(){
        return getPlugin(DontFall_Main.class);
    }
}
